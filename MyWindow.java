import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyWindow extends JFrame {


    public MyWindow() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        JTextArea textAreaMessage = new JTextArea();
        JTextField field = new JTextField();
        JTextField field2 = new JTextField();
        field2.setEnabled(false);
        JPanel mainPanel = new JPanel();
        textAreaMessage.setEditable(false);
        JScrollPane txt = new JScrollPane(textAreaMessage);
        add(txt, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton SendMessage = new JButton("Отправить");
        bottomPanel.add(SendMessage, BorderLayout.EAST);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(field.getText());
                field2.setText(field.getText() + " \n");
                field.setText(" ");
            }
        });
        JTextField message = new JTextField(" ");
        bottomPanel.add(message, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }

    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getExtendedKeyCode() == 10) {
                System.out.println();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
}
 class MainClass {
     public static void main(String[] args) {
         MyWindow myWindow = new MyWindow();
     }
 }




