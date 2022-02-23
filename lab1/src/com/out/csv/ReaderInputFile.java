package com.out.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Pattern;

public class ReaderInputFile {
    private Reader reader;
    private String[] str;

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
        Pattern pattern = Pattern.compile("\\p{Punct}|\\s");
        str = pattern.split(s);
    }

    public String[] getStr() {
        return str;
    }
    public int reternCountWords() {
        return str.length;
    }

    public void closeInputStream() throws IOException {
        reader.close();
    }

}
