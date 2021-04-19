package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BirthdayChocolateTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5", "1 2 1 3 2", "3 2");

        BirthdayChocolate.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("6", "1 1 1 1 1 1", "3 2");

        BirthdayChocolate.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("1", "4", "4 1");

        BirthdayChocolate.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1");
    }
}
