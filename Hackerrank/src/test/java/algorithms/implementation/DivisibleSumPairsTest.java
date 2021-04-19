package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class DivisibleSumPairsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("6 3", "1 3 2 6 1 2");

        DivisibleSumPairs.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }
}
