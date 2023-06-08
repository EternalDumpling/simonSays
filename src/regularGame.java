import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class regularGame{
    public static joeFrame gameFrame = new joeFrame(300,500);
    public static joeBel scoreLabel = new joeBel(100, 50, 100, 50, "Score:", "scoreLabel", Font.BOLD, 30);
    public static joeBel scoreDisplay = new joeBel(100, 50, 100, 80, "0", "scoreDisplay", Font.BOLD, 30);
    public static joeBel gameOver = new joeBel(160, 150, 67, 150, "Game Over!", "gameOver", Font.BOLD, 25);
    public static joeBel timerDisplay = new joeBel(100, 50, 120, 175, "45", "timerDisplay", Font.BOLD, 40);
    public static buttonCreator menuButton =  new buttonCreator(null, "Return", 60, 250, 150, 50);
    public static buttonCreator beginButton =  new buttonCreator(null, "BG", 90, 175, 100, 50);
    public static buttonCreator rButton = new buttonCreator(imageIcons.redOff, "Red", 90, 300, 50, 50);
    public static buttonCreator bButton = new buttonCreator(imageIcons.blueOff, "Blue", 90, 250, 50, 50);
    public static buttonCreator yButton = new buttonCreator(imageIcons.yellowOff, "Yellow",140, 250, 50, 50);
    public static buttonCreator gButton = new buttonCreator(imageIcons.greenOff, "Green", 140, 300, 50, 50);
    public static buttonCreator[] buttons = {rButton, bButton, yButton, gButton};
    public static int gameScore = 0;
    public static challengeTimer challengeTimer = new challengeTimer();
    public static ArrayList<buttonCreator> Sequence = new ArrayList<>();
    public static int currentButton = 0;
    public static boolean challengeMode = false;

    public regularGame(){
        //Frame Setup
        gameOver.setVisible(false);
        beginButton.setText("Begin");
        menuButton.setVisible(false);
        menuButton.setText("Return to Menu");
        gameFrame.add(scoreLabel);
        gameFrame.add(scoreDisplay);
        gameFrame.add(rButton);
        gameFrame.add(bButton);
        gameFrame.add(yButton);
        gameFrame.add(gButton);
        gameFrame.add(beginButton);
        gameFrame.add(gameOver);
        gameFrame.add(menuButton);
        gameFrame.add(timerDisplay);
        timerDisplay.setVisible(false);
        gameFrame.setVisible(true);
    }

    public static void addToSequence(boolean Start){
        if (!Start){
            gameScore++;
        }
        buttonCreator[] Buttons = buttons;
        int randomIndex = (int) (Math.random() * Buttons.length);
        Sequence.add(Buttons[randomIndex]);
        for(buttonCreator val:Sequence){
            System.out.print(val.Name() + " ");
        }
        System.out.println();
        scoreDisplay.setText(String.valueOf(gameScore));
        flashPattern();
    }

    static void flashPattern(){
        challengeTimer.stop();
        for( int i = 0; i < Sequence.size(); i++) {
            buttonCreator Button = Sequence.get(i);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        public void run() {
                            try {
                                Button.flashButton();
                            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    },
                    500L * i
            );
        }
        currentButton = 0;
        if(challengeMode){
            challengeTimer.start();
            timerDisplay.setVisible(true);
        }
    }

    public static void resetGame(){
        Sequence.clear();
        currentButton = 0;
        gameOver.setVisible(false);
        timerDisplay.setText("45");
        menuButton.setVisible(false);
        beginButton.setVisible(true);
        gameScore = 0;
        scoreDisplay.setText("0");
        challengeMode = false;
        timerDisplay.setVisible(false);

        rButton.setVisible(true);
        bButton.setVisible(true);
        yButton.setVisible(true);
        gButton.setVisible(true);

        gameFrame.setVisible(true);
    }
}