package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tetris.domain.Logic;
import tetris.domain.Tetramino;

public class LogicTest {
    private Logic logic;

    @Before
    public void setUp() {
        this.logic = new Logic();
    }
    
    @Test
    public void moveLeftTest() {
        Tetramino current = logic.getCurrent();
        assertTrue(current == null);
        logic.run();
        current = logic.getCurrent();
        assertTrue(current.getX() == 9 && current.getY() == 1);
        for (int i = 0; i < 5; i++) {
            logic.moveLeft();
        }
        assertTrue(current.getX() == 4);
        logic.moveLeft();
        logic.moveLeft();
        //Depending on the tetramino's shape it may have moved one extra step 
        //before colliding with the wall
        assertTrue(current.getX() == 4 || current.getX() == 3);
    }
    
    @Test
    public void moveRightTest() {
        logic = new Logic();
        assertTrue(logic.getCurrent() == null);
        logic.run();
        assertTrue(logic.getCurrent().getX() == 9 
                && logic.getCurrent().getY() == 1);
        logic.moveRight();
        assertTrue(logic.getCurrent().getX() == 10);
        for (int i = 0; i < 10; i++) {
            logic.moveRight();
        }
        //Depending on the tetramino's shape it may have moved one extra step 
        //before colliding with the wall
        assertTrue(logic.getCurrent().getX() == 12 
                || logic.getCurrent().getX() == 13);
    }
    
    @Test
    public void moveDownTest() {
        logic = new Logic();
        logic.run();
        for (int i = 0; i < 22; i++) {
            logic.moveDown();
        }
        //Divided into two cases since there are two possible scenarios 
        //depending on the shape
        assertTrue(logic.getCurrent().getY() == 21 || logic.getCurrent().getY() == 22);
        if (logic.getCurrent().getY() == 21) {
            logic.moveDown();
            assertTrue(logic.getCurrent().getY() == 21);
        }
        else if (logic.getCurrent().getY() == 22) {
            logic.moveDown();
            assertTrue(logic.getCurrent().getY() == 22);
        }
    }
    
    @Test
    public void getDefaultGridTest() {
        logic = new Logic();
        char[][] grid = logic.getGridFromStage();
        // Left and right wall check
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < 4; j++) {
                assertTrue(grid[i][j] == '#');
            }
            for (int j = 16; j < grid[0].length; j++) {
                assertTrue(grid[i][j] == '#');
            }
        }
        //Floor check
        for (int i = grid.length - 4; i < grid.length; i++) {
            for (int j = 4; j < grid[0].length - 4; j++) {
                assertTrue(grid[i][j] == '#');
            }
        }
        //The open level area
        for (int i = 0; i < grid.length - 4; i++) {
            for (int j = 4; j < 16; j++) {
                assertTrue(grid[i][j] == ' ');
            }
        }
    }
    
    @Test
    public void getGridWithTetraminoTest() {
        logic = new Logic();
        logic.run();
        char[][] grid = logic.getGridFromStage();
        //One of these two spaces should always have a '#' in it if there
        //is a tetramino in the grid
        assertTrue(grid[2][10] == '#' || grid[3][10] == '#');
    }
    
    @Test
    public void increaseScoreWorks() {
        logic = new Logic();
        assertTrue(logic.getScoreFromStage() == 0);
        logic.increaseStageScoreOnDown();
        assertTrue(logic.getScoreFromStage() == 1);
        for (int i = 0; i < 37; i++) {
            logic.increaseStageScoreOnDown();
        }
        assertTrue(logic.getScoreFromStage() == 38);
    }
    
    @Test
    public void rotateWorksCorrectly() {
        logic = new Logic();
        logic.run();
        assertTrue(logic.getCurrent().getRotation() == 0);
        logic.rotate();
        assertTrue(logic.getCurrent().getRotation() == 1);
        for (int i = 0; i < 3; i++) {
            logic.rotate();
        }
        assertTrue(logic.getCurrent().getRotation() == 0);
        for (int i = 0; i < 10; i++) {
            logic.moveRight();
        }
        for (int i = 0; i < 5; i++) {
            logic.rotate();
            logic.moveRight();
        }
        assertTrue(logic.getCurrent().getRotation() == 0 || 
                logic.getCurrent().getRotation() == 1 || 
                logic.getCurrent().getRotation() == 2 || 
                logic.getCurrent().getRotation() == 3);
    }
    
    @Test
    public void gameEnds() {
        logic = new Logic();
        char[][] testGrid = logic.getGridFromStage();
        assertTrue(testGrid[27][0] == '#');
        for (int i = 0; i < 24 * 5 * 24; i++) {
            logic.run();
        }
        testGrid = logic.getGridFromStage();
        assertTrue(testGrid[27][0] == 'e');
    }
}
