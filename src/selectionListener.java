import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectionListener implements ActionListener {
    private final JButton button;
    private final String Name;
    public selectionListener(JButton button2, String name) {
        button = button2;
        Name = name;
    }

    public void actionPerformed(ActionEvent e) {
    }
}