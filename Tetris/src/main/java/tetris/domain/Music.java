
package tetris.domain;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Music {
    private boolean playing;
    Clip clip;
    AudioInputStream audioInput;
    File musicPath;
    
    public Music() {
        this.playing = false;
        try {
            this.clip = AudioSystem.getClip();
        } catch (Exception e) {
            System.out.println("Constructor ERROR");
        }
    }
    
    public void playMusic(String musicLocation) {
        System.out.println(this.playing);
        if (this.playing) {
            try {
                this.clip.stop();
                this.musicPath = new File(musicLocation);
                if (this.musicPath.exists()) {
                    this.audioInput = AudioSystem.getAudioInputStream(this.musicPath);
                    this.clip.open(this.audioInput);
                    this.clip.start();
                    return;
                } else {
                    System.out.println("Can't find file");
                }
            } catch (Exception e) {
                System.out.println("RestartERROR");
            }
        } else {
            try {
                this.musicPath = new File(musicLocation);
                if (this.musicPath.exists()) {
                    this.audioInput = AudioSystem.getAudioInputStream(this.musicPath);

                    System.out.println("2");
                    this.clip.open(this.audioInput);
                    System.out.println("3");
                    this.clip.start();
                    System.out.println("4");
                    this.playing = true;

                    //JOptionPane.showMessageDialog(null, "Press OK to stop to stop playing");
                } else {
                    System.out.println("Can't find file");
                }
            } catch (Exception e) {
                System.out.println("MUSIC ERROR");
            }
        }
        this.playing = true;
    }
    
    public void stopPlaying() {
        this.clip.stop();
        this.playing = false;
    }
    
}
