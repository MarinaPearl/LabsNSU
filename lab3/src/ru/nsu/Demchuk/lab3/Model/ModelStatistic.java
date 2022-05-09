package ru.nsu.Demchuk.lab3.Model;

import ru.nsu.Demchuk.lab3.View.RegistrationView;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public  class ModelStatistic {
    public static HashMap<String, Integer> sortedMap = new HashMap<String, Integer>();
//    public ModelStatistic () {
//        sortedMap = new HashMap<String, Integer>();
//    }
    public static HashMap<String, Integer> getSortedMap() {
        int lines = Model.getLine();
        String name = RegistrationView.getName();
        sortedMap.put(name, lines);
        //System.out.println(sortedMap.size());
        HashMap<String, Integer> map = sortedMap.entrySet().stream()
               .sorted(Comparator.comparingInt(e -> -e.getValue()))
               .collect(Collectors.toMap(
                       Map.Entry::getKey,
                       Map.Entry::getValue,
                       (a, b) -> { throw new AssertionError(); },
                       LinkedHashMap::new
               ));
        return map;
    }
}
