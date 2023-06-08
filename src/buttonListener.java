import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class buttonListener implements ActionListener {
    private final String Name;
    public buttonListener(String name) {
        Name = name;
    }
    static boolean previousGame = false;

    public void actionPerformed(ActionEvent e) {
        switch (this.Name){
            case "Red", "Blue", "Yellow", "Green" -> {
                int currentButton = regularGame.currentButton;
                ArrayList<buttonCreator> Sequence = regularGame.Sequence;
                buttonCreator Obj = Sequence.get(currentButton);
                if ((Objects.equals(Obj.Name(), this.Name)) && currentButton < Sequence.size()){
                    regularGame.currentButton++;
                    try {
                        check(regularGame.currentButton, Sequence);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    }
                } else{
                    try {
                        playSound.playWrong();
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    regularGame.gameOver.setVisible(true);
                    regularGame.menuButton.setVisible(true);
                    regularGame.rButton.setVisible(false);
                    regularGame.bButton.setVisible(false);
                    regularGame.gButton.setVisible(false);
                    regularGame.yButton.setVisible(false);
                    regularGame.challengeTimer.stop();
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
            }
            case "BG" -> {
                regularGame.addToSequence(true);
                regularGame.beginButton.setVisible(false);
            }
            case "Return" -> {
                regularGame.gameFrame.setVisible(false);
                Main.selectorMain.setVisible(true);
                playSound.stopPlayback();
            }
            case "RM" -> {
                System.out.println(previousGame);
                if(!previousGame) {
                    //noinspection InstantiationOfUtilityClass
                    new regularGame();
                    changeState();
                }else{
                    regularGame.resetGame();
                }
                Main.selectorMain.setVisible(false);
            }
            case "HM" -> {
                System.out.println(previousGame);
                if(!previousGame) {
                    //noinspection InstantiationOfUtilityClass
                    new regularGame();
                    changeState();
                }else{
                    regularGame.resetGame();
                }
                regularGame.challengeMode = true;
                Main.selectorMain.setVisible(false);
            }
            case "HS" -> System.out.println("High Scores");
        }
    }

    void check(int currentButton, ArrayList<buttonCreator> Sequence) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(currentButton == Sequence.size()){
            playSound.playCorrect();
            regularGame.addToSequence(false);
        }
    }
    void changeState(){
        previousGame = true;
    }
}