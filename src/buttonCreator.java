import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

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

    public void flashButton() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        setIcon(handleOn());
        playSound.playClick();
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        setIcon(handleOff());
                    }
                },
                250
        );
    }
}
