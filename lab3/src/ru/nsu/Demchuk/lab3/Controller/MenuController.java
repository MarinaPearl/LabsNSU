package ru.nsu.Demchuk.lab3.Controller;

import javafx.stage.Stage;
import ru.nsu.Demchuk.lab3.Model.ModelStatistic;
import ru.nsu.Demchuk.lab3.View.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MenuController {
    private static final int EXIT = 0;
   public  static void play(Stage primaryStage) {
       RegistrationView registration = new RegistrationView(primaryStage);
       registration.makeRegistration();
   }
   public static void exit(Stage stage) {
       stage.close();
   }
   public static void showStatistic(Stage primaryStage) throws IOException, ClassNotFoundException {
       HashMap<String, Integer> statisticMap = ModelStatistic.getSortedMap();
       StatisticView game = new StatisticView(primaryStage);
       game.doStatistic(statisticMap);
   }
    public static void showAboutView(Stage stage) {
        AboutView about = new AboutView(stage);
        about.showAbout();
    }
}
