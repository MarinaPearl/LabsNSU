package ru.nsu.lab1.out;

import javafx.util.Pair;

import java.io.*;
import java.util.List;

import static ru.nsu.lab1.out.Constants.*;

public class WriterToCSV implements Closeable {
    private PrintWriter writer;
    private char delimiter = ';';

    public WriterToCSV(String path) throws FileNotFoundException
    {
        writer = new PrintWriter(new File(path));
    }
    public void writeToFile(List<Pair<String, Integer>> list, int count)
    {
        for (int i = START; i < list.size(); ++i) {
            writer.write(list.get(i).getKey() + delimiter +  list.get(i).getValue() +delimiter+
                    (double)(list.get(i).getValue() * MAX_PERCENT / count)  + LINE_TRUNSLATION);

        }
    }
    public void closeOut() throws IOException
    {
        writer.close();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}

