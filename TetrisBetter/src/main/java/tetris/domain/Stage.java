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
    
    private char[][] blockGrid;
    
    public Stage() {
        //Creates a 12*24 grid with walls outside that are 4 wide
        //The actual play area:
        //width: 4-15, height: 0-23
        
        this.blockGrid = new char[28][20];
        for (int i = 0; i < 24; i++) {
            //Left "wall"
            for (int j = 0; j < 4; j++) {
                blockGrid[i][j] = '#';
            }
            //Right "wall"
            for (int j = 16; j < 20; j++) {
                blockGrid[i][j] = '#';
            }
        }
        //"Floor"
        for (int i = 24; i < 28; i++) {
            for (int j = 0; j < 20; j++) {
                blockGrid[i][j] = '#';
            }
        }
        //The play area
        for (int i = 0; i < blockGrid.length - 4; i++) {
            for (int j = 4; j < 16; j++) {
                blockGrid[i][j] = ' ';
            }
        }
    }
    
    public char getBlock(int x, int y) {
        return blockGrid[x][y];
    }

    public boolean collidesWith(Tetramino tetramino) {
        char[][] chars = tetramino.getCollisionCheck();
        for (int dx = 0; dx < 4; dx++) {
            for (int dy = 0; dy < 4; dy++) {
                if (chars[dx][dy] != ' ' && blockGrid[tetramino.x + dx][tetramino.y + dy] != ' ') {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void placeTetramino(Tetramino tetramino) {
        char[][] chars = tetramino.getCollisionCheck();
        for (int dx = 0; dx < 4; dx++) {
            for (int dy = 0; dy < 4; dy++) {
                if (chars[dx][dy] != ' ') {
                    blockGrid[tetramino.x + dx][tetramino.y + dy] = '#';
                }
            }
        }
    }

//    private static class Block {
//        //x och y onödiga?
//        private int x;
//        private int y;
//
//        public Block() {
//            
//        }
//        
//        public int getX() {
//            return this.x;
//        }
//        public int getY() {
//            return this.y;
//        }
//    }
    
}
