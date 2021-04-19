package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ClosestNumbersTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("10",
                "-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 ");

        ClosestNumbers.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("-20 30");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("12",
                "-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470 ");

        ClosestNumbers.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("-520 -470 -20 30");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("4",
                "5 4 3 2");

        ClosestNumbers.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2 3 3 4 4 5");
    }
}
