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
    
    @Test
    public void removeRowWorks() {
        stage = new Stage();
        assertTrue(stage.getScore() == 0);
        
        stage.placeTetramino(new Tetramino(4, 22, I));
        stage.placeTetramino(new Tetramino(8, 22, I));
        stage.placeTetramino(new Tetramino(12, 22, I));
        
        char[][] blockGrid = stage.getBlockGrid();
        for (int i = 4; i < 16; i++) {
            assertTrue(blockGrid[23][i] == '#');
        }
        stage.removeRowsCheck();
        for (int i = 4; i < 16; i++) {
            assertTrue(blockGrid[23][i] == ' ');
        }
        assertTrue(stage.getScore() == 100);
    }
}
