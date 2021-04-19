package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class PermutingTwoArraysTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "3 10",
                "2 1 3",
                "7 8 9",
                "4 5",
                "1 2 2 1",
                "3 3 3 4");

        PermutingTwoArrays.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES", "NO");
    }
}
