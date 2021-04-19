package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SherlockAndAnagramsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "abba",
                "abcd");

        SherlockAndAnagrams.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4", "0");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5",
                "ifailuhkqq",
                "hucpoltgty",
                "ovarjsnrbf",
                "pvmupwjjjf",
                "iwwhrlkpek");

        SherlockAndAnagrams.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3",
                "2",
                "2",
                "6",
                "3");
    }
}
