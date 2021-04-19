package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BeautifulBinaryStringTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("7", "0101010");

        BeautifulBinaryString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5", "01100");

        BeautifulBinaryString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("10", "0100101010");

        BeautifulBinaryString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
