package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class GridlandMetroTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4 4 4",
                "2 3 3",
                "2 2 3",
                "3 1 4",
                "4 4 4");

        GridlandMetro.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("9");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("4 5 7",
                "1 1 2",
                "1 4 4",
                "2 1 2",
                "2 2 3",
                "2 4 5",
                "4 1 2",
                "4 4 5");

        GridlandMetro.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("8");
    }
}
