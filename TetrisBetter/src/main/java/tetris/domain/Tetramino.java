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
    
    public static char[][] rotateCollisionCheck(char[][] toBeRotated) {
        return toBeRotated;
    }
    
    public void rotate() {
        rotation = rotation == 3 ? 0 : rotation + 1;
    }
    
    public char[][] getCollisionCheck() {
        char[][] collisionCheck = shape.getDefaultCollisionCheck();
        
        for (int rotationsMade = 0; rotationsMade < rotation; rotationsMade++) {
            collisionCheck = rotateCollisionCheck(collisionCheck);
        }
        return collisionCheck;
    }
    
    public static enum Shape {
        L, J, S, Z, I, O, T;
        
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
                        {' ', '#', ' ', ' '},
                        {'#', '#', '#', ' '},
                        {' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' '},
                    };
                default:
                    return null;
            }
        }
    }
}
