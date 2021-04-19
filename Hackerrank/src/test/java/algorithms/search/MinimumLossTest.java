package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MinimumLossTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "5 10 3");

        MinimumLoss.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5",
                "20 7 8 2 5");

        MinimumLoss.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }
}
