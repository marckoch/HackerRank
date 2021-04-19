package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class PairsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5 2",
                "1 5 3 4 2");

        Pairs.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
