
package tetris;

import javafx.application.Application;
import javafx.stage.Stage;

public class Tetris extends Application {

    @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("Hei Maailma!");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(Tetris.class);
    }
}