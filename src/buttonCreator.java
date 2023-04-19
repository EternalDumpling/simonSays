import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class buttonCreator extends JButton {
    public buttonCreator(ImageIcon Img, String name, int X, int Y, int W, int H) {
        setName(name);
        setIcon(Img);
        setBounds(X, Y, W, H);
        setVisible(true);
        addActionListener(new buttonListener(name));
    }

    public String Name() {
        return this.getName();
    }

    ImageIcon handleOn() {
        switch (this.Name()) {
            case "Red" -> {
                return imageIcons.redOn;
            }
            case "Blue" -> {
                return imageIcons.blueOn;
            }
            case "Yellow" -> {
                return imageIcons.yellowOn;
            }
            case "Green" -> {
                return imageIcons.greenOn;
            }
            default -> {
                return null;
            }
        }
    }

    ImageIcon handleOff() {
        switch (this.Name()) {
            case "Red" -> {
                return imageIcons.redOff;
            }
            case "Blue" -> {
                return imageIcons.blueOff;
            }
            case "Yellow" -> {
                return imageIcons.yellowOff;
            }
            case "Green" -> {
                return imageIcons.greenOff;
            }
            default -> {
                return null;
            }
        }
    }

    public void flashButton(){
        //setIcon(handleOn());
        setVisible(false);
        System.out.println("Changed On");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
            e.printStackTrace();
        }
        //setIcon(handleOff());
        setVisible(true);
        System.out.println("Changed Off");
    }
}