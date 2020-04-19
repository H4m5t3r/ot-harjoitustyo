
package tetris.main;

import java.util.Arrays;
import tetris.domain.Controller;
import tetris.domain.Form;

public class TestMain {
    public static void main(String[] args) {
        int move = 25;
        int size = 25;
        int xmax = size * 12;
        int ymax = size * 24;
        int[][] mesh = new int[xmax / size][ymax / size];
        int score = 0;
        int top = 0;
        boolean game = true;
        int linesNo = 0;
        
        for (int[] a : mesh) {
            Arrays.fill(a, 0);
        }
        
        Controller controller = new Controller(25, 25, 25 * 12, 25 * 25);
        
        Form form = new Form();
    }
}
