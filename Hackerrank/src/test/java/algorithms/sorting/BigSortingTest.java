package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BigSortingTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6",
                "31415926535897932384626433832795",
                "1",
                "3",
                "10",
                "3",
                "5");

        BigSorting.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1",
                "3",
                "3",
                "5",
                "10",
                "31415926535897932384626433832795");
    }
}
