
package tetris;

import javafx.application.Application;
import javafx.stage.Stage;

public class Tetris extends Application {
    
    //Variables
    public static final int MOVE = 25;
    public static final int SIZE = 25;

    @Override
    public void start(Stage ikkuna) throws Exception {
        ikkuna.setTitle("Hei Maailma!");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(Tetris.class);
    }
}