import javafx.scene.shape.Rectangle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Form;
import tetris.domain.Tetris;

public class TetrisTest {
    Form form;
    Tetris tetris;
    Rectangle a;
    Rectangle b;
    Rectangle c;
    Rectangle d;

    @Before
    public void setUp() {
        a = new Rectangle();
        b = new Rectangle();
        c = new Rectangle();
        d = new Rectangle();
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void moveUpWorks() {
        a.setY(50);
        tetris.moveUp(a);
        assertTrue(a.getY() == 25);
    }
}