package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class HackerRankInAStringTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2", "hereiamstackerrank", "hackerworld");

        HackerRankInAString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES", "NO");
    }
}
