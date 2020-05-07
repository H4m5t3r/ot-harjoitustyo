package tests;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import tetris.domain.Tetramino;
import tetris.domain.Tetramino.Shape;
import static tetris.domain.Tetramino.Shape.I;
import static tetris.domain.Tetramino.Shape.J;
import static tetris.domain.Tetramino.Shape.L;
import static tetris.domain.Tetramino.Shape.O;
import static tetris.domain.Tetramino.Shape.S;
import static tetris.domain.Tetramino.Shape.T;
import static tetris.domain.Tetramino.Shape.Z;


public class TetraminoTest {
    private Tetramino tetramino;

    @Before
    public void setUp() {
        Shape shape;
        shape = J;
        this.tetramino = new Tetramino(0, 9, shape);
    }

    @Test
    public void getXWorks() {
        assertTrue(tetramino.getX() == 0);
    }
    
    @Test
    public void getYWorks() {
        assertTrue(tetramino.getY() == 9);
    }
    
    @Test
    public void rotateCollisionCheckWorks() {
        char[][] rotateTest = new char[][] {
            {' ', '#', ' ', ' '},
            {' ', '#', ' ', ' '},
            {' ', '#', '#', ' '},
            {' ', ' ', ' ', ' '},
        };
         
        char[][] rotated = Tetramino.rotateCollisionCheck(rotateTest);
        char[][] correct = new char[][] {
            {' ', ' ', ' ', ' '},
            {' ', '#', '#', '#'},
            {' ', '#', ' ', ' '},
            {' ', ' ', ' ', ' '},
        };
        
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[0].length; j++) {
                assertTrue(rotated[i][j] == correct[i][j]);
            }
        }
    }
    
    @Test
    public void rotateWorks() {
        assertTrue(tetramino.getRotation() == 0);
        tetramino.rotate();
        assertTrue(tetramino.getRotation() == 1);
        tetramino.rotate();
        assertTrue(tetramino.getRotation() == 2);
        tetramino.rotate();
        assertTrue(tetramino.getRotation() == 3);
        tetramino.rotate();
        assertTrue(tetramino.getRotation() == 0);
    }
    
    @Test
    public void getCollisionCheckWorks() {
        Tetramino tetramino = new Tetramino(0, 9, J);
        char[][] collisionCheck = tetramino.getCollisionCheck();
        char[][] correct = new char[][] {
            {' ', ' ', '#', ' '},
            {' ', ' ', '#', ' '},
            {' ', '#', '#', ' '},
            {' ', ' ', ' ', ' '},
        };
        for (int i = 0; i < collisionCheck.length; i++) {
            for (int j = 0; j < collisionCheck[0].length; j++) {
                assertTrue(collisionCheck[i][j] == correct[i][j]);
            }
        }
        
        tetramino = new Tetramino(0, 9, L);
        collisionCheck = tetramino.getCollisionCheck();
        correct = new char[][] {
            {' ', '#', ' ', ' '},
            {' ', '#', ' ', ' '},
            {' ', '#', '#', ' '},
            {' ', ' ', ' ', ' '},
        };
        for (int i = 0; i < collisionCheck.length; i++) {
            for (int j = 0; j < collisionCheck[0].length; j++) {
                assertTrue(collisionCheck[i][j] == correct[i][j]);
            }
        }
        
        tetramino = new Tetramino(0, 9, S);
        tetramino.rotate();
        collisionCheck = tetramino.getCollisionCheck();
        correct = new char[][] {
            {' ', '#', ' ', ' '},
            {' ', '#', '#', ' '},
            {' ', ' ', '#', ' '},
            {' ', ' ', ' ', ' '},
        };
        for (int i = 0; i < collisionCheck.length; i++) {
            for (int j = 0; j < collisionCheck[0].length; j++) {
                assertTrue(collisionCheck[i][j] == correct[i][j]);
            }
        }
        
        tetramino = new Tetramino(0, 9, Z);
        collisionCheck = tetramino.getCollisionCheck();
        correct = new char[][] {
            {' ', ' ', ' ', ' '},
            {'#', '#', ' ', ' '},
            {' ', '#', '#', ' '},
            {' ', ' ', ' ', ' '},
        };
        for (int i = 0; i < collisionCheck.length; i++) {
            for (int j = 0; j < collisionCheck[0].length; j++) {
                assertTrue(collisionCheck[i][j] == correct[i][j]);
            }
        }
        
        tetramino = new Tetramino(0, 9, I);
        collisionCheck = tetramino.getCollisionCheck();
        correct = new char[][] {
            {' ', ' ', ' ', ' '},
            {'#', '#', '#', '#'},
            {' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' '},
        };
        for (int i = 0; i < collisionCheck.length; i++) {
            for (int j = 0; j < collisionCheck[0].length; j++) {
                assertTrue(collisionCheck[i][j] == correct[i][j]);
            }
        }
        
        tetramino = new Tetramino(0, 9, O);
        collisionCheck = tetramino.getCollisionCheck();
        correct = new char[][] {
            {' ', ' ', ' ', ' '},
            {' ', '#', '#', ' '},
            {' ', '#', '#', ' '},
            {' ', ' ', ' ', ' '},
        };
        for (int i = 0; i < collisionCheck.length; i++) {
            for (int j = 0; j < collisionCheck[0].length; j++) {
                assertTrue(collisionCheck[i][j] == correct[i][j]);
            }
        }
        
        tetramino = new Tetramino(0, 9, T);
        collisionCheck = tetramino.getCollisionCheck();
        correct = new char[][] {
            {' ', ' ', ' ', ' '},
            {' ', '#', ' ', ' '},
            {'#', '#', '#', ' '},
            {' ', ' ', ' ', ' '},
        };
        for (int i = 0; i < collisionCheck.length; i++) {
            for (int j = 0; j < collisionCheck[0].length; j++) {
                assertTrue(collisionCheck[i][j] == correct[i][j]);
            }
        }
    }
}
