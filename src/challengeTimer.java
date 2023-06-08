import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class challengeTimer{
    private Timer timer;
    private int timeLeft = 45;

    public challengeTimer() {

        timer = new Timer(1000, e -> {
            timeLeft--;
            if (timeLeft >= 0) {
                if(timeLeft > 9) {
                    regularGame.timerDisplay.setText(String.valueOf(timeLeft));
                }else{
                    regularGame.timerDisplay.setText("0"+timeLeft);
                }
            } else {
                try {
                    playSound.playBazinga();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
                regularGame.gameOver.setVisible(true);
                regularGame.menuButton.setVisible(true);
                regularGame.rButton.setVisible(false);
                regularGame.bButton.setVisible(false);
                regularGame.gButton.setVisible(false);
                regularGame.yButton.setVisible(false);
                timer.stop();
                try {
                    Thread.sleep(1250);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    playSound.playOutro();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void start(){
        timer.restart();
    }
    public void stop(){
        timeLeft = 45;
        regularGame.timerDisplay.setText("45");
        timer.stop();
    }
}
