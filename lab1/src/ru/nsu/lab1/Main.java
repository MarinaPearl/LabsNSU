package ru.nsu.lab1;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import ru.nsu.lab1.out.SorterWords;
import ru.nsu.lab1.out.ReaderInputFile;
import ru.nsu.lab1.out.WriterToCSV;
import static ru.nsu.lab1.out.Constants.INPUT_FILE;
import static ru.nsu.lab1.out.Constants.OUTPUT_FILE;

public class Main {


    public static void main(String[] args) throws Exception {
        try (ReaderInputFile file = new ReaderInputFile(args[INPUT_FILE]);
             WriterToCSV writer = new WriterToCSV(args[OUTPUT_FILE]))
        {

            file.fileToString();
            SorterWords sort = new SorterWords(file.getStr());
            sort.symbolToMap();
            sort.MapToList();
            sort.sorterList();
            writer.writeToFile(sort.getList(), file.reternCountWords());

        } catch (IOException | ArrayIndexOutOfBoundsException myError)
        {
            System.err.println(myError.getMessage());
        }
        }
}

