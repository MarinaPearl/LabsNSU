package ru.nsu.lab1.out;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Pattern;

public class ReaderInputFile implements AutoCloseable{
    private Reader reader;
    private String[] str;
    private final String Separator = "\\p{Punct}|\\s";
    public ReaderInputFile(String path) throws IOException {
        reader = new InputStreamReader(new FileInputStream(path));
    }

    public void fileToString() throws IOException {
        String line = null;
        BufferedReader buffer = new BufferedReader(this.reader);
        StringBuilder varRead = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            varRead.append(line);
            varRead.append(" ");
        }
        String s = new String(varRead);
        Pattern pattern = Pattern.compile("Separator");
        str = pattern.split(s);
    }

    public String[] getStr() {
        return str;
    }
    public int reternCountWords() {
        return str.length;
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
