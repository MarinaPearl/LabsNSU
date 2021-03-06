package ru.nsu.Demchuk.lab3.Model;

import ru.nsu.Demchuk.lab3.View.RegistrationView;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public  class ModelStatistic {
    public static HashMap<String, Integer> sortedMap = new HashMap<String, Integer>();
   private static FileWriter writer;
   private static FileReader reader;
   private static  final String PATH_TO_STATISTIC = "static.txt";
   private static  final String PATH_TO_CLASS = "ru.nsu.Demchuk.lab3.Model.ModelStatistic";
    public static HashMap<String, Integer> getSortedMap() throws IOException, ClassNotFoundException {
        try {
            reader = new FileReader("D:/labsNsuJava/lab3/src/ru/nsu/Demchuk/lab3/Model/statistic.txt");
            Scanner scanner = new Scanner(reader);
            String s;
            int k = 0;
            String name1 = null;
            int size = 0;
            while (scanner.hasNext()) {
                //k = 0;
                s = scanner.next();
               // System.out.println(s);
                    if (k == 0) {
                        name1 = s;
                        //System.out.println("s" + name1);
                    }
                    if (k == 1) {
                        try {
                            size = Integer.valueOf(s);
                            sortedMap.put(name1, size);
                            //System.out.println(size);
                            k = 0;
                            continue;
                        } catch (NumberFormatException error) {
                            error.printStackTrace();
                        }
                    }
                    ++k;
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
        for (Map.Entry<String, Integer> m : sortedMap.entrySet()) {
            if (m.getKey() != null) {
                System.out.println(m.getKey() + " " + m.getValue());
            }

        }
        reader.close();
        int lines = Model.getLine();
        String name = RegistrationView.getName();
        writer = new FileWriter("D:/labsNsuJava/lab3/src/ru/nsu/Demchuk/lab3/Model/statistic.txt", true);
        if (name != null)
        sortedMap.put(name, lines);
        HashMap<String, Integer> map = sortedMap.entrySet().stream()
               .sorted(Comparator.comparingInt(e -> -e.getValue()))
               .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (a, b) -> { throw new AssertionError(); },
                       LinkedHashMap::new
               ));
        for (Map.Entry<String, Integer> map1: map.entrySet()) {
            if (map1.getKey() != null)
            writer.write(map1.getKey() + " " + map1.getValue() + "\n");
        }
        writer.close();
        return map;
    }
}
