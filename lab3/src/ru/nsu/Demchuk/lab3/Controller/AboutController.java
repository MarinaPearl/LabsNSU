package ru.nsu.Demchuk.lab3.Controller;

import javafx.stage.Stage;
import ru.nsu.Demchuk.lab3.View.Main;

public class AboutController {
    public static void doBack(Stage stage) {
        Main retur = new Main();
        try {
            retur.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
