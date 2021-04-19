package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class AppleAndOrangeTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("7 11",
                "5 15",
                "3 2",
                "-2 2 1",
                "5 -6");

        AppleAndOrange.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1", "1");
    }
}
