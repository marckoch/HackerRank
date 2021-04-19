package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CutTheSticksTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6", "5 4 4 2 2 8");

        CutTheSticks.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("6", "4", "2", "1");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("8", "1 2 3 4 3 3 2 1");

        CutTheSticks.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("8", "6", "4", "1");
    }
}
