package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BreakingTheRecordsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("9", "10 5 20 20 4 5 2 25 1");

        BreakingTheRecords.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2 4");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("10", "3 4 21 36 10 28 35 5 24 42");

        BreakingTheRecords.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4 0");
    }
}
