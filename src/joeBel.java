import javax.swing.*;
import java.awt.*;

public class joeBel extends JLabel {
    public joeBel(int W, int H, int X, int Y, String Text, String fontName, int fontType, int fontSize){
        setBounds(W, H, X, Y);
        setFont(new Font(fontName, fontType, fontSize));
        setText(Text);
        setVisible(true);
    }
}
