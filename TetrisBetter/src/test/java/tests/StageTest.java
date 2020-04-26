package tests;


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
        collides = new Tetramino(13, 0, I);
        doesNotCollide = new Tetramino(12, 0, I);
    }

    @Test
    public void collidesWithWorks() {
        assertTrue(stage.collidesWith(collides) == true);
        assertTrue(stage.collidesWith(doesNotCollide) == false);
    }
    
    @Test
    public void placeTetraminoWorks() {
        char[][] grid = stage.getBlockGrid();
        assertTrue(grid[1][12] == ' ');
        assertTrue(grid[1][13] == ' ');
        assertTrue(grid[1][14] == ' ');
        assertTrue(grid[1][15] == ' ');
        stage.placeTetramino(doesNotCollide);
        assertTrue(grid[1][12] == '#');
        assertTrue(grid[1][13] == '#');
        assertTrue(grid[1][14] == '#');
        assertTrue(grid[1][15] == '#');
    }
}
