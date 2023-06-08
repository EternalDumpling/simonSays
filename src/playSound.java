import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class playSound {
    private static Clip clip;

    public static void playClick() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File soundFile = new File("C:\\Users\\zowie\\Documents\\GitHub\\simonSays\\Sounds\\Click.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    public static void playCorrect() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File soundFile = new File("C:\\Users\\zowie\\Documents\\GitHub\\simonSays\\Sounds\\Correct.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    public static void playWrong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File soundFile = new File("C:\\Users\\zowie\\Documents\\GitHub\\simonSays\\Sounds\\Wrong.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    public static void playBazinga() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File soundFile = new File("C:\\Users\\zowie\\Documents\\GitHub\\simonSays\\Sounds\\Bazinga.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    public static void playOutro() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File soundFile = new File("C:\\Users\\zowie\\Documents\\GitHub\\simonSays\\Sounds\\Outro.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }

    public static void stopPlayback() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
