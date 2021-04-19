package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ChocolateFeastTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("3",
                "10 2 5",
                "12 4 4",
                "6 2 2");

        ChocolateFeast.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("6", "3", "5");
    }
}
