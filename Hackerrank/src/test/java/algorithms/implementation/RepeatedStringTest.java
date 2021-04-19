package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class RepeatedStringTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("aba", "10");

        RepeatedString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("7");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("a", "1000000000000");

        RepeatedString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1000000000000");
    }
}
