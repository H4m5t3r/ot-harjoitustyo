package tests;


import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tetris.domain.Music;
import tetris.domain.Tetramino;
import tetris.domain.Tetramino.Shape;
import static tetris.domain.Tetramino.Shape.I;
import static tetris.domain.Tetramino.Shape.J;
import static tetris.domain.Tetramino.Shape.L;
import static tetris.domain.Tetramino.Shape.O;
import static tetris.domain.Tetramino.Shape.S;
import static tetris.domain.Tetramino.Shape.T;
import static tetris.domain.Tetramino.Shape.Z;


public class MusicTest {
    private Music music;

    @Before
    public void setUp() {
        this.music = new Music();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
    }
    
    @Test
    public void isNotPlayingWhenFilepathIsIncorrect() {
        music.playMusic("ImperialMarch.wav");
        assertTrue(music.isPlaying() == false);
    }
}
