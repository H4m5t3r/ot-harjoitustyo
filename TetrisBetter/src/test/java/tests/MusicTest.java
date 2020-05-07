package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tetris.domain.Music;


public class MusicTest {
    private Music music;

    @Before
    public void setUp() {
        this.music = new Music();
    }

    @Test
    public void notPlayingInTheBeginning() {
        assertTrue(music.isPlaying() == false);
    }
    
    @Test
    public void playsMusicAndStopsPlayingBeforeStartingAgain() {
        music.playMusic("TetrisPiano.wav");
        assertTrue(music.isPlaying() == true);
        music.playMusic("TetrisPiano.wav");
        assertTrue(music.isPlaying() == true);
        music.stopPlaying();
        assertTrue(music.isPlaying() == false);
        music.stopPlaying();
        assertTrue(music.isPlaying() == false);
    }
    
    @Test
    public void isNotPlayingWhenFilepathIsIncorrect() {
        music.playMusic("ImperialMarch.wav");
        assertTrue(music.isPlaying() == false);
    }
}
