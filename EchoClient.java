import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient extends JFrame {
    private final String SERVER_ADDR = "localhost" ;
    private final Integer SERVER_PORT = 8189;
    private JTextField msgInputField;
    private JTextArea chatArea;
    private Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    public EchoClient() {
        try {
            connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prepareGUI();
    }
    public void connection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
                try {
                    while ( true ) {
                        String message = dis.readUTF();
                        if (message.equalsIgnoreCase("/q")) {
                            this.dispose();
                            break;
                        }
                        chatArea.append(message + "\n");
                    }
                } catch (IOException ignored){
                }

        }).start();
    }

    public void send() {
        if (msgInputField.getText() != null && !msgInputField.getText().trim().isEmpty()) {
            try {
                dos.writeUTF(msgInputField.getText());
                chatArea.append(msgInputField.getText() + "\n");
                msgInputField.setText("");
            } catch (IOException ignored) {
            }
        }
    }

    public void prepareGUI() {
        setBounds( 600 , 300 , 500 , 500 );
        setTitle( "Клиент" );
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chatArea = new JTextArea();
        chatArea.setEditable( false );
        chatArea.setLineWrap( true );
        add( new JScrollPane(chatArea), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel( new BorderLayout());
        JButton btnSendMsg = new JButton( "Отправить" );
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(e -> {
            send();
        });
        msgInputField.addActionListener(e -> {
            send();
        });
        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super .windowClosing(e);
            }
        });
        setVisible( true );
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EchoClient();
        });
    }
}
