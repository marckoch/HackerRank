package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class StrangeCounterTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("4");

        StrangeCounter.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("6");
    }
}
