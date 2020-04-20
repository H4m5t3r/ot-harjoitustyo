/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;
    
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Music {
    private boolean playing;
    private Clip clip;
    private File file;
    
    public Music() {
        this.playing = false;
    }
    
    public void PlayMusic(String filepath) {
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
    
    public void StopPlaying() {
        if (playing) {
            clip.stop();
            playing = false;
        }
    }
}

