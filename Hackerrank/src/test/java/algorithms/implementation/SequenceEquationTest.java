package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SequenceEquationTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("3", "2 3 1");

        SequenceEquation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2", "3", "1");
    }
}
