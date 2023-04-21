import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class buttonListener implements ActionListener {
    private final String Name;
    public buttonListener(String name) {
        Name = name;
    }


    public void actionPerformed(ActionEvent e) {
        switch (this.Name){
            case "Red", "Blue", "Yellow", "Green" -> {
                int currentButton = regularGame.currentButton;
                ArrayList<buttonCreator> Sequence = regularGame.Sequence;
                buttonCreator Obj = Sequence.get(currentButton);
                if ((Objects.equals(Obj.Name(), this.Name)) && currentButton < Sequence.size()){
                    System.out.println("Correct!");
                    regularGame.currentButton++;
                    System.out.println("Current Button: " + regularGame.currentButton);
                    System.out.println("Sequence Size: "+ Sequence.size());
                    check(regularGame.currentButton, Sequence);
                } else{
                    System.out.println("Game Over!");
                    regularGame.gameOver.setVisible(true);
                    regularGame.menuButton.setVisible(true);
                    regularGame.rButton.setVisible(false);
                    regularGame.bButton.setVisible(false);
                    regularGame.gButton.setVisible(false);
                    regularGame.yButton.setVisible(false);
                    //regularGame.gameFrame.dispose();
                }
            }
            case "BG" -> {
                regularGame.addToSequence();
                regularGame.beginButton.setVisible(false);
            }
            case "RM" -> System.out.println("Regular Mode");
            case "HM" -> System.out.println("Hard Mode");
            case "HS" -> System.out.println("High Scores");
        }
    }

    void check(int currentButton, ArrayList<buttonCreator> Sequence) {
        if(currentButton == Sequence.size()){
            System.out.println("Check");
            regularGame.gameScore++;
            regularGame.addToSequence();
        }
    }
}