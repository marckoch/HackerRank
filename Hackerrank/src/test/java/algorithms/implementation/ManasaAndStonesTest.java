package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ManasaAndStonesTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("2",
                "3",
                "1",
                "2",
                "4",
                "10",
                "100");

        ManasaAndStones.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2 3 4",
                "30 120 210 300");
    }
}
