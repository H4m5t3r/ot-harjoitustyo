
package tetris.domain;

/**
 * Contains a block grid that is used to check if a tetramino collides
 * with the level and placing rectangles in the GUI.
 */
public class Stage {
    
    private final char[][] blockGrid;
    private long score;
    
    /**
     *  Creates a 12*24 grid with walls outside the game area that are 4 wide
     *  The actual play area:
     *  width: 4-15, height: 0-23
     */
    public Stage() {
        
        this.blockGrid = new char[28][20];
        for (int y = 0; y < 24; y++) {
            //Left "wall"
            for (int x = 0; x < 4; x++) {
                blockGrid[y][x] = '#';
            }
            //Right "wall"
            for (int x = 16; x < 20; x++) {
                blockGrid[y][x] = '#';
            }
        }
        //"Floor"
        for (int y = 24; y < 28; y++) {
            for (int x = 0; x < 20; x++) {
                blockGrid[y][x] = '#';
            }
        }
        //The play area
        for (int y = 0; y < blockGrid.length - 4; y++) {
            for (int x = 4; x < 16; x++) {
                blockGrid[y][x] = ' ';
            }
        }
        score = 0;
    }
    
    /**
     * Checks if a tetramino collides with blocks in the grid when it is in a
     * specific spot.
     * @param tetramino
     * @return 
     */
    //
    public boolean collidesWith(Tetramino tetramino) {
        char[][] chars = tetramino.getCollisionCheck();
        for (int dx = 0; dx < 4; dx++) {
            for (int dy = 0; dy < 4; dy++) {
                if (chars[dy][dx] != ' ' && blockGrid[tetramino.y + dy][tetramino.x + dx] != ' ') {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Merges a tetramino with the grid.
     * @param tetramino 
     */
    public void placeTetramino(Tetramino tetramino) {
        char[][] chars = tetramino.getCollisionCheck();
        for (int dx = 0; dx < 4; dx++) {
            for (int dy = 0; dy < 4; dy++) {
                if (chars[dy][dx] != ' ') {
                    blockGrid[tetramino.y + dy][tetramino.x + dx] = '#';
                }
            }
        }
    }
    
    /**
     * Checks if there are rows that are full and should be removed.
     */
    public void removeRowsCheck() {
        outer: for (int y = 0; y < 24; y++) {
            for (int x = 4; x < blockGrid[y].length - 4; x++) {
                if (blockGrid[y][x] != '#') {
                    continue outer;
                }
            }
            removeRow(y);
        }
    }

    /**
     * Removes a row and lowers the blocks above that row by one.
     * @param heightLimit
     */
    public void removeRow(int heightLimit) {
        for (int y = heightLimit; y > 0; y--) {
            for (int x = 0; x < blockGrid[heightLimit].length; x++) {
                blockGrid[y][x] = blockGrid[y - 1][x];
            }
        }
        score += 100;
    }
    
    public char[][] getBlockGrid() {
        return this.blockGrid;
    }
    
    public void increaseScore() {
        score += 1;
    }
    
    public long getScore() {
        return this.score;
    }
    
    /**
     * Puts the character "e" in the grid so that the updateGameScreen() method
     * in TetrisUI notices it and displays the text "GAME OVER".
     */
    public void setGameEnd() {
        blockGrid[27][0] = 'e';
    }
}
