package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FindTheMedianTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("7",
                "0 1 2 4 6 5 3");

        FindTheMedian.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
