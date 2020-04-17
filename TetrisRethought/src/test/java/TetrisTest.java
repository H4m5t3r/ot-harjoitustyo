
import org.junit.Before;
import org.junit.Test;
import tetris.domain.Tetris;
import static org.junit.Assert.*;

public class TetrisTest {
    Tetris tetris;
    
    @Before
    public void setUp(){
        this.tetris = new Tetris();
    }
    
    @Test
    public void initializerWorks(){
        assertTrue(this.tetris.game == true);
        this.tetris.gameFalse();
        assertTrue(this.tetris.game == false);
    }
}
