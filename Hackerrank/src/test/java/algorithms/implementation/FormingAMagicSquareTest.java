package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FormingAMagicSquareTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4 9 2",
                "3 5 7",
                "8 1 5");

        FormingAMagicSquare.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("4 8 2",
                "4 5 7",
                "6 1 6");

        FormingAMagicSquare.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }
}
