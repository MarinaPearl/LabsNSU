package ru.nsu.Demchuk.lab3.Controller;

import javafx.stage.Stage;
import ru.nsu.Demchuk.lab3.View.Main;
import ru.nsu.Demchuk.lab3.View.TetrisView;

public class RegistrartionController {
    public void doGame(Stage primaryStage) {
        TetrisView game = new TetrisView(primaryStage);
        try {
            game.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doBack(Stage stage) {
        Main retur = new Main();
        try {
            retur.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
