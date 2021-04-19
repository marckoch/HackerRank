package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CountingValleysTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("8", "UDDDUDUU");

        CountingValleys.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1");
    }
}
