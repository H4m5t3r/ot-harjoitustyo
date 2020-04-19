/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author taleiko
 */
public class Stage {
    
    private Block[][] blockGrid;

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

        public Block() {
            
        }
    }
    
}
