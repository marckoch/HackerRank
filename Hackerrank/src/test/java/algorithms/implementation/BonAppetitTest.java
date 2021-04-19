package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BonAppetitTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4 1", "3 10 2 9", "12");

        BonAppetit.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("4 1", "3 10 2 9", "7");

        BonAppetit.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Bon Appetit");
    }
}
