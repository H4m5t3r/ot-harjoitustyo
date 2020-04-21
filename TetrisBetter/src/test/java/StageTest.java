
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tetris.domain.Stage;
import tetris.domain.Tetramino;
import static tetris.domain.Tetramino.Shape.I;


public class StageTest {
    private Stage stage;
    private Tetramino collides;
    private Tetramino doesNotCollide;

    @Before
    public void setUp() {
        stage = new Stage();
        collides = new Tetramino(0, 13, I);
        doesNotCollide = new Tetramino(0, 12, I);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void collidesWithWorks() {
        assertTrue(stage.collidesWith(collides) == true);
        assertTrue(stage.collidesWith(doesNotCollide) == false);
    }
    
    @Test
    public void placeTetraminoWorks() {
        assertTrue(stage.getBlock(1, 12) == ' ');
        assertTrue(stage.getBlock(1, 13) == ' ');
        assertTrue(stage.getBlock(1, 14) == ' ');
        assertTrue(stage.getBlock(1, 15) == ' ');
        stage.placeTetramino(doesNotCollide);
        assertTrue(stage.getBlock(1, 12) == '#');
        assertTrue(stage.getBlock(1, 13) == '#');
        assertTrue(stage.getBlock(1, 14) == '#');
        assertTrue(stage.getBlock(1, 15) == '#');
    }
}
