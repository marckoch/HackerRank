package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MarsExplorationTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("SOSSPSSQSSOR");

        MarsExploration.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("SOSSOT");

        MarsExploration.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1");
    }
}
