import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    private final JTextArea textArea;
    private final JTextField textMassage;

    public MyWindow() {
        setTitle("Chat");
        setBounds(1000, 400, 600, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout());

        JPanel bottonPanel = new JPanel();
        add(bottonPanel, BorderLayout.SOUTH);
        bottonPanel.setPreferredSize(new Dimension(20, 50));
        bottonPanel.setLayout(new BorderLayout());

        JButton startButton = new JButton("Enter");
        bottonPanel.add(startButton, BorderLayout.EAST);

        textArea = new JTextArea();
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        centerPanel.add(textAreaScroll, BorderLayout.CENTER);
        textArea.setEditable(false);

        textMassage = new JTextField();
        bottonPanel.add(textMassage, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addText();
            }
        });

        textMassage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addText();
            }
        });

        setVisible(true);
    }
    void addText() {
        textArea.append(textMassage.getText()+"\n");
        textMassage.setText(null);
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}




