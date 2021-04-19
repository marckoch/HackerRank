package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class Quicksort1PartitionTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5",
                "4 5 3 7 2");

        Quicksort1Partition.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3 2 4 5 7");
    }

    @Test
    public void testSample4() {
        systemInMock.provideLines("50",
                "-13 68 -43 -71 -39 -10 40 -49 -19 -3 -70 -62 -76 -94 -73 64 72 -5 88 2 -63 92 -40 16 49 47 -86 -51 -9 -14 96 74 -22 -34 38 -12 6 63 19 -69 14 -90 -27 76 54 57 -87 -91 43 -92");

        Quicksort1Partition.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("-43 -71 -39 -49 -19 -70 -62 -76 -94 -73 -63 -40 -86 -51 -14 -22 -34 -69 -90 -27 -87 -91 -92 -13 68 -10 40 -3 64 72 -5 88 2 92 16 49 47 -9 96 74 38 -12 6 63 19 14 76 54 57 43");
    }
}
