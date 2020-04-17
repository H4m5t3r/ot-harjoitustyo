
package tetris.domain;

public class Tetris {
    //The tetris variables
    public int move;
    public int size;
    public int xmax;
    public int ymax;
    public int[][] mesh;
    public int score;
    public int top;
    public boolean game;
    public int linesNo;
    
    //Creating the required classes
    Controller controller;
    
    public Tetris(){
        move = 25;
        size = 25;
        xmax = this.size * 12;
        ymax = this.size * 24;
        mesh = new int[this.xmax / this.size][this.ymax / this.size];
        score = 0;
        top = 0;
        game = true;
        linesNo = 0;
        
        controller = new Controller(move, size, xmax, ymax);
    }
}
