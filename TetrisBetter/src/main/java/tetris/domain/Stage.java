/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;

/**
 *
 * @author taleiko
 */
public class Stage {
    
    private Block[][] blockGrid;
    
    public Stage() {
        //Creates a 12*24 grid with walls outside that are 4 wide
        //The actual play area:
        //width: 4-15, height: 4-27
        this.blockGrid = new Block[28][20];
//        for (int i = 0; i < ; i++) {
//            Block[] blocks = blockGrid[i];
//            
//        }
    }

    boolean collidesWith(Tetramino tetramino) {
        char[][] chars = tetramino.getCollisionCheck();
        for (int dx = 0; dx < 4; dx++) {
            for (int dy = 0; dy < 4; dy++) {
                if (chars[dx][dy] != ' ' && blockGrid[tetramino.x + dx][tetramino.y + dy] != null) {
                    return true;
                }
            }
        }
        return false;
    }
    
    void placeTetramino(Tetramino tetramino) {
        char[][] chars = tetramino.getCollisionCheck();
        for (int dx = 0; dx < 4; dx++) {
            for (int dy = 0; dy < 4; dy++) {
                if (chars[dx][dy] != ' ') {
                    blockGrid[tetramino.x + dx][tetramino.y + dy] = new Block();
                }
            }
        }
    }

    private static class Block {
        //x och y onödiga?
        private int x;
        private int y;

        public Block() {
            
        }
        
        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
    }
    
}
