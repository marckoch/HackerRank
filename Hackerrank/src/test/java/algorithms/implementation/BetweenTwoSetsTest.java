package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BetweenTwoSetsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("2 3",
                "2 4",
                "16 32 96");

        BetweenTwoSets.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
