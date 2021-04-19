package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class JumpingOnTheCloudsRevisitedTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("8 2", "0 0 1 0 0 1 1 0");

        JumpingOnTheCloudsRevisited.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("92");
    }
}
