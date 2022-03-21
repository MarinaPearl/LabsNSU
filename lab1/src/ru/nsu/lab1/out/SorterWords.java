package ru.nsu.lab1.out;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.nsu.lab1.out.Constants.*;

public class SorterWords {
    private Map<String, Integer> myMap;
    private String[] str;
    private List<Pair<String, Integer>> list;
    public SorterWords(String[] str) {
        this.str = str;
    }

    public void symbolToMap() {
        this.myMap = new HashMap();
        for (String string : this.str) {
            if (string.hashCode() != EXAMINATION) {
                this.myMap.put(string, myMap.getOrDefault(string, KEY_INITIALIZATION) + COUNTER_VALUE);
            }
        }
    }
    public void MapToList () {
        this.list = new ArrayList<Pair<String, Integer>>();
        for (Map.Entry<String, Integer> e : myMap.entrySet()) {
            list.add(new Pair(e.getKey(), e.getValue()));
        }
    }
    public void sorterList(){
        Collections.sort(this.list, new SorterList());
    }
    public List<Pair<String, Integer>> getList () {
        return this.list;
    }
}

