package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FindDigitsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("2", "12", "1012");

        FindDigits.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2", "3");
    }
}
