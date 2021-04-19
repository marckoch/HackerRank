package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class AnagramTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6",
                "aaabbb",
                "ab",
                "abc",
                "mnop",
                "xyyx",
                "xaxbbbxx");

        Anagram.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3",
                "1",
                "-1",
                "2",
                "0",
                "1");
    }
}
