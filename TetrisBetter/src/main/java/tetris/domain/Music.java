
package tetris.domain;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * A class used for playing music. It does not use any of the classes created 
 * in this project and can therefore be used outside of it.
 */
public class Music {
    private boolean playing;
    private Clip clip;
    private File file;
    
    public Music() {
        this.playing = false;
    }
    
    public void playMusic(String filepath) {
        System.out.println(playing);
        if (playing) {
            clip.stop();
        }
        file = new File(filepath);
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            playing = true;
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    public void stopPlaying() {
        if (playing) {
            clip.stop();
            playing = false;
        }
    }
    
    public boolean isPlaying() {
        return this.playing;
    }
}

