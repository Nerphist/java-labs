package ua.kpi.tef.ti71.lab4.fileReaders;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileReadersTest {

    @Test
    public void testReadWholeFileOnEmptyFile() {
        String fileContent = FileReaders.readWholeFile("empty.txt");

        assertEquals("", fileContent);

    }

    @Test
    public void testReadWholeFileOnFileWithEmptyLines() {
        String fileContent = FileReaders.readWholeFile("lines.txt");

        assertEquals("Hey!\n" +
                "\n" +
                "What's up?\n" +
                "\n" +
                "Hi!", fileContent);
    }

    @Test
    public void testReadWholeFile() {
        String fileContent = FileReaders.readWholeFile("simple.txt");

        assertEquals("Hello!\n" + "It's a test file.", fileContent);
    }
}
