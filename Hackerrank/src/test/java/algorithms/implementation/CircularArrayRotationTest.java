package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CircularArrayRotationTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("3 2 3", "1 2 3", "0", "1", "2");

        CircularArrayRotation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2", "3", "1");
    }
}
