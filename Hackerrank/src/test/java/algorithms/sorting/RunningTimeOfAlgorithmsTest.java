package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class RunningTimeOfAlgorithmsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5",
                "2 1 3 1 2");

        RunningTimeOfAlgorithms.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }

    @Test
    public void testNoShiftsInSortedArray1() {
        systemInMock.provideLines("12",
                "1 1 2 2 3 3 5 5 7 7 9 9");

        RunningTimeOfAlgorithms.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }

    @Test
    public void testMaximalShiftsInInvertedArray1() {
        systemInMock.provideLines("12",
                "9 9 7 7 5 5 3 3 2 2 1 1");

        RunningTimeOfAlgorithms.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("60");
    }

    @Test
    public void testNoShiftsInSortedArray2() {
        systemInMock.provideLines("5",
                "1 2 3 4 5");

        RunningTimeOfAlgorithms.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }

    @Test
    public void testMaximalShiftsInInvertedArray2() {
        systemInMock.provideLines("5",
                "5 4 3 2 1");

        RunningTimeOfAlgorithms.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("10");
    }
}
