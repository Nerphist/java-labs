package ua.kpi.tef.ti71.lab4.fileStats;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileStatsTest {

    @Test
    public void testCreateFileStatsFromExistingFile() {
        FileStats fileStats = FileStats.from("sotl.txt");
    }

    @Test
    public void testCreateFileStatsFromNonExistingFile() {
        Assertions.assertThrows(FileStatsException.class, () -> {
            FileStats fileStats = FileStats.from("blahblah.txt");
        });
    }

    @Test
    public void testGetCharCount() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        int aCharCountInLambdaArticle = lambdaArticleFileStats.getCharCount('a');
        int bCharCountInSpringArticle = springCloudArticleFileStats.getCharCount('b');

        assertEquals(2345, aCharCountInLambdaArticle);
        assertEquals(4, bCharCountInSpringArticle);
    }

    @Test
    public void testGetMostPopularCharacter() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        char mostPopularCharacterInLambdaArticle = lambdaArticleFileStats.getMostPopularCharacter();
        char mostPopularCharacterInSpringArticle = springCloudArticleFileStats.getMostPopularCharacter();

        System.out.println(mostPopularCharacterInSpringArticle);

        assertEquals('e', mostPopularCharacterInLambdaArticle);
        assertEquals('e', mostPopularCharacterInSpringArticle);
    }

    @Test
    public void testContainsCharacter() {
        FileStats lambdaArticleFileStats = FileStats.from("sotl.txt");
        FileStats springCloudArticleFileStats = FileStats.from("scosb.txt");

        boolean lambdaArticleContainsExistingCharacter = lambdaArticleFileStats.containsCharacter('a');
        boolean lambdaArticleContainsWhitespace = lambdaArticleFileStats.containsCharacter(' ');
        boolean springArticleContainsExistingCharacter = springCloudArticleFileStats.containsCharacter('b');
        boolean springArticleContainsWhitespace = springCloudArticleFileStats.containsCharacter(' ');

        assertTrue(lambdaArticleContainsExistingCharacter);
        assertFalse(lambdaArticleContainsWhitespace);
        assertTrue(springArticleContainsExistingCharacter);
        assertFalse(springArticleContainsWhitespace);
    }
}
