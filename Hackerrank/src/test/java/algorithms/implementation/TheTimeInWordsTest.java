package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class TheTimeInWordsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("5", "47");

        TheTimeInWords.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("thirteen minutes to six");
    }
}
