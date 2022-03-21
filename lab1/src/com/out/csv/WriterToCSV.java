package com.out.csv;

import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.out.csv.Constants.MAX_PERCENT;

public class WriterToCSV {
    private PrintWriter writer;
    private char delimiter = ';';

    public WriterToCSV(String path) throws FileNotFoundException
    {
        writer = new PrintWriter(new File(path));
    }
    public void writeToFile(List<Pair<String, Integer>> list, int count)
    {
        for (int i = 0; i < list.size(); ++i)
            writer.write(list.get(i).getKey() + delimiter +  list.get(i).getValue() +delimiter+
                    (double)(list.get(i).getValue() * MAX_PERCENT / count)  + "\n");{

        }
    }
    public void closeOut() throws IOException
    {
        writer.close();
    }
}

