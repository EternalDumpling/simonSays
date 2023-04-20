import java.awt.*;
import java.util.ArrayList;

public class regularGame{
    public static ArrayList<buttonCreator> Sequence = new ArrayList<>();
    public static int currentButton = 0;
    public static joeFrame gameFrame = new joeFrame(300,500);
    public static joeBel scoreLabel = new joeBel(100, 50, 100, 50, "Score:", "scoreLabel", Font.BOLD, 30);
    public static joeBel scoreDisplay = new joeBel(132, 90, 150, 50, "0", "scoreDisplay", Font.BOLD, 30);
    public static buttonCreator beginButton =  new buttonCreator(null, "BG", 90, 175, 100, 50);
    public static buttonCreator rButton = new buttonCreator(imageIcons.redOff, "Red", 90, 300, 50, 50);
    public static buttonCreator bButton = new buttonCreator(imageIcons.blueOff, "Blue", 90, 250, 50, 50);
    public static buttonCreator yButton = new buttonCreator(imageIcons.yellowOff, "Yellow",140, 250, 50, 50);
    public static buttonCreator gButton = new buttonCreator(imageIcons.greenOff, "Green", 140, 300, 50, 50);
    public static buttonCreator[] buttons = {rButton, bButton, yButton, gButton};
    public static int gameScore = 0;

    public regularGame(){
        //Frame Setup
        gameFrame.add(scoreLabel);
        gameFrame.add(scoreDisplay);
        gameFrame.add(rButton);
        gameFrame.add(bButton);
        gameFrame.add(yButton);
        gameFrame.add(gButton);
        gameFrame.add(beginButton);
        gameFrame.setVisible(true);
    }

    public static void addToSequence(){
        buttonCreator[] Buttons = buttons;
        int randomIndex = (int) (Math.random() * Buttons.length);
        Sequence.add(Buttons[randomIndex]);
        System.out.println("Added: "+Buttons[randomIndex].Name());
        flashPattern();
    }

    static void flashPattern()
    {
        for( int i = 0; i < Sequence.size(); i++) {
            buttonCreator Button = Sequence.get(i);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        public void run() {
                            Button.flashButton();
                        }
                    },
                    500L *i
            );
        }
        currentButton = 0;
    }
}