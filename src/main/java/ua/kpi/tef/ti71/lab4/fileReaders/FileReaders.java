package ua.kpi.tef.ti71.lab4.fileReaders;

import groovy.json.internal.IO;
import ua.kpi.tef.ti71.lab4.fileStats.FileStatsException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) throws IOError {
        try (BufferedReader br = new BufferedReader(new FileReader(FileReaders.class.getClassLoader().getResource(fileName).getFile()))) {
            StringJoiner sj = new StringJoiner("\n");
            String line;
            while((line = br.readLine()) != null) {
                sj.add(line);
            }
            return sj.toString();
        } catch (IOException | NullPointerException e) {
            throw new IOError(e);
        }
    }
}
