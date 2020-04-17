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
        this.tetris = new Tetris();
        a = new Rectangle(24, 24);
        b = new Rectangle(24, 24);
        c = new Rectangle(24, 24);
        d = new Rectangle(24, 24);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void moveUpWorks() {
        this.a.setY(50);
        assertTrue(this.a.getY() == 50);
    }
}
