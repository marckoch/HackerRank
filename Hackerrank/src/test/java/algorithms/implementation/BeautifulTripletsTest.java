package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BeautifulTripletsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("7 3", "1 2 4 5 7 8 10");

        BeautifulTriplets.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
