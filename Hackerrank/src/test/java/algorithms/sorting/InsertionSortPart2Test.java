package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class InsertionSortPart2Test extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6",
                "1 4 3 5 6 2");

        InsertionSortPart2.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 4 3 5 6 2",
                "1 3 4 5 6 2",
                "1 3 4 5 6 2",
                "1 3 4 5 6 2",
                "1 2 3 4 5 6");
    }
}
