package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SeparateTheNumbersTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("7",
                "1234",
                "91011",
                "99100",
                "101103",
                "010203",
                "13",
                "1");

        SeparateTheNumbers.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES 1",
                "YES 9",
                "YES 99",
                "NO",
                "NO",
                "NO",
                "NO");
    }
}
