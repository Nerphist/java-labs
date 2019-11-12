package ua.kpi.tef.ti71.lab4.fileStats;

import ua.kpi.tef.ti71.lab4.fileReaders.FileReaders;

import java.io.IOError;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link FileStats} provides an API that allow to get character statistic based on text file. All whitespace characters
 * are ignored.
 */
public class FileStats {
    private Map<Character, AtomicInteger> characterOccurrences;

    public FileStats(String fileName) {
        String contents;
        try {
            contents = FileReaders.readWholeFile(fileName);
        } catch (NullPointerException e) {
            throw new FileStatsException("File was not found", e);
        }
        characterOccurrences = new HashMap<>();
        for (char character : contents.toCharArray()) {
            if (characterOccurrences.containsKey(character)) {
                characterOccurrences.get(character).incrementAndGet();
            } else if (character != ' ') {
                characterOccurrences.put(character, new AtomicInteger(1));
            }
        }
    }

    /**
     * Creates a new immutable {@link FileStats} objects using data from text file received as a parameter.
     *
     * @param fileName input text file name
     * @return new FileStats object created from text file
     */
    public static FileStats from(String fileName) {
        return new FileStats(fileName);
    }

    /**
     * Returns a number of occurrences of the particular character.
     *
     * @param character a specific character
     * @return a number that shows how many times this character appeared in a text file
     */
    public int getCharCount(char character) {
        return characterOccurrences.containsKey(character)
                ? characterOccurrences.get(character).get() : 0;
    }

    /**
     * Returns a character that appeared most often in the text.
     *
     * @return the most frequently appeared character
     */
    public char getMostPopularCharacter() {
        return Collections.max(characterOccurrences.entrySet(),
                Comparator.comparingInt((e) -> e.getValue().get())).getKey();

    }

    /**
     * Returns {@code true} if this character has appeared in the text, and {@code false} otherwise
     *
     * @param character a specific character to check
     * @return {@code true} if this character has appeared in the text, and {@code false} otherwise
     */
    public boolean containsCharacter(char character) {
        return this.characterOccurrences.containsKey(character);
    }
}
