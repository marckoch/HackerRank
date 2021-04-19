package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class TheFullCountingSortTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("20",
                "0 ab",
                "6 cd",
                "0 ef",
                "6 gh",
                "4 ij",
                "0 ab",
                "6 cd",
                "0 ef",
                "6 gh",
                "0 ij",
                "4 that",
                "3 be",
                "0 to",
                "1 be",
                "5 question",
                "1 or",
                "2 not",
                "4 is",
                "2 to",
                "4 the");

        TheFullCountingSort.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("- - - - - to be or not to be - that is the question - - - -");
    }
}
