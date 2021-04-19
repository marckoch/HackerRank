package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class PickingNumbersTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6", "4 6 5 3 3 1");

        PickingNumbers.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("6", "1 2 2 3 1 2");

        PickingNumbers.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }
}
