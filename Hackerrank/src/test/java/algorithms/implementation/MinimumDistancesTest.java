package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MinimumDistancesTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("6", "7 1 3 4 1 7");

        MinimumDistances.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
