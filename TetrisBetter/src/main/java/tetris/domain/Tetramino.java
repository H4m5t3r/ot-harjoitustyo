
package tetris.domain;

/**
 * A class that describes one of the falling objects. It contains the 
 * tetramino's coordinates as well as its shape (an Enum) and rotation.
 */
public class Tetramino {
    
    int x;
    int y;
    private final Shape shape;
    private int rotation;
    
    public Tetramino(int x, int y, Shape shape) {
        this.x = x;
        this.y = y;
        this.shape = shape;
        rotation = 0;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public int getRotation() {
        return this.rotation;
    }
    
    /**
     * Returns a 90 degree clockwise rotated array.
     * @param toBeRotated
     * @return 
     */
    public static char[][] rotateCollisionCheck(char[][] toBeRotated) {
        char[][] rotated = new char[4][4];
        rotated[0][0] = toBeRotated[3][0]; //The first row
        rotated[0][1] = toBeRotated[2][0];
        rotated[0][2] = toBeRotated[1][0];
        rotated[0][3] = toBeRotated[0][0];
        rotated[1][0] = toBeRotated[3][1]; //The second row
        rotated[1][1] = toBeRotated[2][1];
        rotated[1][2] = toBeRotated[1][1];
        rotated[1][3] = toBeRotated[0][1];
        rotated[2][0] = toBeRotated[3][2]; // The third row
        rotated[2][1] = toBeRotated[2][2];
        rotated[2][2] = toBeRotated[1][2];
        rotated[2][3] = toBeRotated[0][2];
        rotated[3][0] = toBeRotated[3][3]; //The fourth row
        rotated[3][1] = toBeRotated[2][3];
        rotated[3][2] = toBeRotated[1][3];
        rotated[3][3] = toBeRotated[0][3];
        return rotated;
    }
    
    /**
     * Increases the tetramino's rotation status or returns it to 0 if it is 3.
     */
    public void rotate() {
        rotation = rotation == 3 ? 0 : rotation + 1;
    }
    
    /**
     * Returns a 4 * 4 array that matches the current tetramino's shape
     * and rotation.
     * @return 
     */
    public char[][] getCollisionCheck() {
        char[][] collisionCheck = shape.getDefaultCollisionCheck();
        
        for (int rotationsMade = 0; rotationsMade < rotation; rotationsMade++) {
            collisionCheck = rotateCollisionCheck(collisionCheck);
        }
        return collisionCheck;
    }
    
    /**
    * A class used to determine what shape a tetramino will have.
    */
    public static enum Shape {
        L, J, S, Z, I, O, T;
        
        /**
         * Returns a 4 * 4 array that matches the shape's default rotation.
         * @return 
         */
        private char[][] getDefaultCollisionCheck() {
            switch (this) {
                case L:
                    return new char[][] {
                        {' ', '#', ' ', ' '},
                        {' ', '#', ' ', ' '},
                        {' ', '#', '#', ' '},
                        {' ', ' ', ' ', ' '},
                    };
                case J:
                    return new char[][] {
                        {' ', ' ', '#', ' '},
                        {' ', ' ', '#', ' '},
                        {' ', '#', '#', ' '},
                        {' ', ' ', ' ', ' '},
                    };
                case S:
                    return new char[][] {
                        {' ', ' ', ' ', ' '},
                        {' ', '#', '#', ' '},
                        {'#', '#', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                    };
                case Z:
                    return new char[][] {
                        {' ', ' ', ' ', ' '},
                        {'#', '#', ' ', ' '},
                        {' ', '#', '#', ' '},
                        {' ', ' ', ' ', ' '},
                    };
                case I:
                    return new char[][] {
                        {' ', ' ', ' ', ' '},
                        {'#', '#', '#', '#'},
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                    };
                case O:
                    return new char[][] {
                        {' ', ' ', ' ', ' '},
                        {' ', '#', '#', ' '},
                        {' ', '#', '#', ' '},
                        {' ', ' ', ' ', ' '},
                    };
                case T:
                    return new char[][] {
                        {' ', ' ', ' ', ' '},
                        {' ', '#', ' ', ' '},
                        {'#', '#', '#', ' '},
                        {' ', ' ', ' ', ' '},
                    };
                default:
                    throw new UnsupportedOperationException("Input shape incorrect");
            }
        }
    }
}
