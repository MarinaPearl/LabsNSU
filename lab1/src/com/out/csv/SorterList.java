package com.out.csv;

import javafx.util.Pair;

import java.util.Comparator;

public class SorterList implements Comparator<Pair<String,Integer>>
{
    @Override
    public int compare (Pair<String, Integer> a, Pair<String, Integer> b)
    {
        return b.getValue() - a.getValue();
    }
}
