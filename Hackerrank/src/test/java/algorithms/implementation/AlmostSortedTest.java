package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class AlmostSortedTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2", "4 2");

        AlmostSorted.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("yes", "swap 1 2");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("3", "3 1 2");

        AlmostSorted.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("no");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("6", "1 5 4 3 2 6");

        AlmostSorted.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("yes", "reverse 2 5");
    }
}
