package ru.nsu.Demchuk.lab3.Controller;

import javafx.stage.Stage;
import ru.nsu.Demchuk.lab3.Model.ModelStatistic;
import ru.nsu.Demchuk.lab3.View.Main;
import ru.nsu.Demchuk.lab3.View.RegistrationView;
import ru.nsu.Demchuk.lab3.View.StatisticView;
import ru.nsu.Demchuk.lab3.View.TetrisView;

import java.util.*;
import java.util.stream.Collectors;

public class MenuController {
   public  static void play(Stage primaryStage) {
//       TetrisView game = new TetrisView(primaryStage);
//       try {
//           game.start();
//       } catch (Exception e) {
//           e.printStackTrace();
//       }
//       HashMap<String, Integer> map = new HashMap<String, Integer>();
//       map.put("Katy",2);
//       map.put("Marina", 5);
//       map.put("Dasha", 1);
//       map.put("l", 10);
//       HashMap<String, Integer> sortedMap = map.entrySet().stream()
//               .sorted(Comparator.comparingInt(e -> -e.getValue()))
//               .collect(Collectors.toMap(
//                       Map.Entry::getKey,
//                       Map.Entry::getValue,
//                       (a, b) -> { throw new AssertionError(); },
//                       LinkedHashMap::new
//               ));
//       StatisticView game = new StatisticView(primaryStage);
//       game.doStatistic(sortedMap);
       RegistrationView registration = new RegistrationView(primaryStage);
       registration.makeRegistration();
   }
   public static void exit() {
       System.exit(0);
   }
   public static void showStatistic(Stage primaryStage) {
       HashMap<String, Integer> statisticMap = ModelStatistic.getSortedMap();
       StatisticView game = new StatisticView(primaryStage);
       game.doStatistic(statisticMap);
   }
}
