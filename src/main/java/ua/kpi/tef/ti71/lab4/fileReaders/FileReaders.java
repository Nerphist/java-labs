package ua.kpi.tef.ti71.lab4.fileReaders;

import groovy.json.internal.IO;
import ua.kpi.tef.ti71.lab4.fileStats.FileStatsException;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            Stream<String> lines = Stream.of("");

            try {
                lines = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }

            return lines.collect(Collectors.joining("\n", "", ""));
    }
}
