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
    
    public int getRotation() {
        return this.rotation;
    }
    
    public static char[][] rotateCollisionCheck(char[][] toBeRotated) {
        char[][] rotated = new char[4][4];
        rotated[0][0] = toBeRotated[3][0]; //First row
        rotated[0][1] = toBeRotated[2][0];
        rotated[0][2] = toBeRotated[1][0];
        rotated[0][3] = toBeRotated[0][0];
        rotated[1][0] = toBeRotated[3][1]; //Second row
        rotated[1][1] = toBeRotated[2][1];
        rotated[1][2] = toBeRotated[1][1];
        rotated[1][3] = toBeRotated[0][1];
        rotated[2][0] = toBeRotated[3][2]; // Third row
        rotated[2][1] = toBeRotated[2][2];
        rotated[2][2] = toBeRotated[1][2];
        rotated[2][3] = toBeRotated[0][2];
        rotated[3][0] = toBeRotated[3][3]; //Fourth row
        rotated[3][1] = toBeRotated[2][3];
        rotated[3][2] = toBeRotated[1][3];
        rotated[3][3] = toBeRotated[0][3];
        return rotated; //returns a 90 degree clockwise rotated array
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
