package serverside.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.DataOutputStream;
import java.util.Scanner;

public class ClientHandler {

    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private String name;

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } finally {
                    closeConnection();
                }

            }).start();
        } catch (IOException e) {
            System.out.println("Server problem");
        }
    }

    private void authentication() throws IOException {
        while (true) {
            String authStr = dis.readUTF();
            if (authStr.startsWith("/auth")) {
                String[] arr = authStr.split("\\s");
                String nick = myServer
                        .getAuthService()
                        .getNickByLoginAndPassword(arr[1], arr[2]);
                if (!nick.isEmpty()) {
                    if (!myServer.isNickBusy(nick)) {
                        sendMessage("/authok " + nick);
                        name = nick;
                        myServer.sendMessageToClients(nick + " Joined to chat");
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMessage(name + " is busy");
                    }
                } else {
                    sendMessage("Wrong login/password");
                }
            }
            //Добавить отключение неавторизованных пользователей по таймауту
            //(120 сек. ждем после подключения клиента.
            //Если он не авторизовался за это время, закрываем соединение).
            try {
                while (true) {
                    Scanner inMessage = new Scanner(System.in);
                    String clientMessage = dis.readUTF();
                    if (inMessage.hasNext()) {
                        clientMessage = inMessage.nextLine();
                    }
                    if (clientMessage.equalsIgnoreCase("session end")) {
                        break;
                    }
                    Thread.sleep(120);
                }
            } catch (InterruptedException ignored) {
                
            } finally {
                this.closeConnection();
            }

        }
    }

    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
            dos.flush();
        } catch (IOException ignored) {
        }
    }

    public String getName() {
        return name;
    }

    private void readMessage() throws IOException {
        while (true) {
            String messageFromClient = dis.readUTF();
            if (messageFromClient.equals("/q")) {
                sendMessage(messageFromClient);
                return;
            }
            myServer.sendMessageToClients(name + ": " + messageFromClient);
        }
    }

    private void closeConnection() {
        myServer.unSubscribe(this);
        myServer.sendMessageToClients(name + " leave chat");
    }


}
