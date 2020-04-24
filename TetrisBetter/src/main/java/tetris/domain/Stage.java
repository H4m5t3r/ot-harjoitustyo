/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

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
    }
    
    public char getBlock(int x, int y) {
        return blockGrid[y][x];
    }

    public boolean collidesWith(Tetramino tetramino) {
        char[][] chars = tetramino.getCollisionCheck();
        for (int dx = 0; dx < 4; dx++) {
            for (int dy = 0; dy < 4; dy++) {
                if (chars[dy][dx] != ' ' && blockGrid[tetramino.y + dy][tetramino.x + dx] != ' ') {
//                    System.out.println("Collide " + dx + ", " + dy);
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
                if (chars[dy][dx] != ' ') {
                    blockGrid[tetramino.y + dy][tetramino.x + dx] = '#';
                }
            }
        }
    }
    
    //Game logic stops working correctly if this method is used?
    public void removeRowsCheck() {
        return;
//        for (int y = 23; y > 0; y--) {
//            if (blockGrid[y][0] == '#') {
//                for (int x = 1; x < blockGrid[y].length; x++) {
//                    if (blockGrid[y][x] != '#') {
//                        break;
//                    }
//                    
//                    removeRow(y);
//                }
//            }
//        }
    }
    
    private void removeRow(int heightLimit) {
        for (int y = heightLimit; y > 0; y--) {
            for (int x = 0; x < blockGrid[heightLimit].length; x++) {
                blockGrid[y][x] = blockGrid[y - 1][x];
            }
        }
    }
    
    public void printPlayArea() {
        for (int y = 0; y < blockGrid.length; y++) {
            for (int x = 0; x < blockGrid[0].length; x++) {
                System.out.print(blockGrid[y][x]);
            }
            System.out.println("");
        }
    }
    
    public Pane getPane(Tetramino current) {
        Pane newPane = new Pane();
        for (int i = 0; i < blockGrid.length; i++) {
            for (int j = 0; j < blockGrid[0].length; j++) {
                if (blockGrid[i][j] == '#') {
                    Rectangle rect = new Rectangle(24, 24);
                    rect.setX(j * 25);
                    rect.setY(i * 25);
                    newPane.getChildren().add(rect);
                }
            }
        }
        //Something wrong with the block check
//        for (int i = 0; i < current.getCollisionCheck().length; i++) {
//            for (int j = 0; j < current.getCollisionCheck()[0].length; j++) {
//                Rectangle recttwo = new Rectangle(24, 24);
//                recttwo.setX((j + current.x));
//                recttwo.setY(i + current.y);
//                newPane.getChildren().add(recttwo);
//            }
//        }
        return newPane;
    }

//    private static class Block {
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
