package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class DrawingBookTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6", "2");

        DrawingBook.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5", "4");

        DrawingBook.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }
}
