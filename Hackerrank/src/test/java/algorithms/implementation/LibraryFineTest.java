package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class LibraryFineTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("9 6 2015", "6 6 2015");

        LibraryFine.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("45");
    }
}
