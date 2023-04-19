import javax.swing.*;

public class selectorMain extends JFrame {
    public selectorMain(){
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton button1 = new JButton("Regular Mode");
        button1.setBounds(55, 75, 175, 30);
        panel.add(button1);

        JButton button2 = new JButton("Hard Mode");
        button2.setBounds(55, 110, 175, 30);
        panel.add(button2);

        JButton button3 = new JButton("High Scores");
        button3.setBounds(55, 145, 175, 30);
        panel.add(button3);
        add(panel);
        setVisible(true);



        button1.addActionListener(new buttonListener("RM"));
        button2.addActionListener(new buttonListener("HM"));
        button3.addActionListener(new buttonListener("HS"));
    }
}
