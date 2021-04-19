package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class PalindromeIndexTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "aaab",
                "baa",
                "aaa");

        PalindromeIndex.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3", "0", "-1");
    }
}
