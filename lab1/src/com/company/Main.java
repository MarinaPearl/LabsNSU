package com.company;

import java.io.IOException;

import com.out.csv.WriterToCSV;
import com.out.csv.SorterWords;
import com.out.csv.ReaderInputFile;
import static com.out.csv.Constants.INPUT_FILE;
import static com.out.csv.Constants.OUTPUT_FILE;

public class Main {


    public static void main(String[] args) throws IOException {
        ReaderInputFile file = null;
        WriterToCSV writer = null;
        try {
            file = new ReaderInputFile(args[INPUT_FILE]);
            file.fileToString();
            SorterWords sort = new SorterWords(file.getStr());
            sort.symbolToMap();
            sort.MapToList();
            sort.sorterList();
            writer = new WriterToCSV(args[OUTPUT_FILE]);
            writer.writeToFile(sort.getList(), file.reternCountWords());

        } catch (IOException | ArrayIndexOutOfBoundsException myError)
        {
            System.err.println(myError.getMessage());
        } finally
        {
            if (file != null) {
                file.closeInputStream();
            }
            if (writer != null) {
                writer.closeOut();
            }
        }
    }
}

