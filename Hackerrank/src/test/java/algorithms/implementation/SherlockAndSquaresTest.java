package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SherlockAndSquaresTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("2", "3 9", "17 24");

        SherlockAndSquares.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2", "0");
    }
}
