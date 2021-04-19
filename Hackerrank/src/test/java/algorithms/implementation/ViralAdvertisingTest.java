package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ViralAdvertisingTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("3");

        ViralAdvertising.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("9");
    }
}
