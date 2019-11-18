package ua.kpi.tef.ti71.lab4.fileReaders;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * {@link FileReaders} privides an API that allow to read whole file into a {@link String} by file name.
 */
public class FileReaders {

    private FileReaders() {
    }

    /**
     * Returns a {@link String} that contains whole text from the file specified by name.
     *
     * @param fileName a name of a text file
     * @return string that holds whole file content
     */
    public static String readWholeFile(String fileName) throws IOError {

        try (var lines = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
            return lines.collect(Collectors.joining("\n", "", ""));
        } catch (IOException | URISyntaxException e) {
            return "";
        }

    }
}
