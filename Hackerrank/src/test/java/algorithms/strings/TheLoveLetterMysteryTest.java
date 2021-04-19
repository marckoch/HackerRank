package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class TheLoveLetterMysteryTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4",
                "abc",
                "abcba",
                "abcd",
                "cba");

        TheLoveLetterMystery.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2",
                "0",
                "4",
                "2");
    }
}
