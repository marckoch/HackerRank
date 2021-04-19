package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class JumpingOnTheCloudsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("7", "0 0 1 0 0 1 0");

        JumpingOnTheClouds.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("6", "0 0 0 0 1 0");

        JumpingOnTheClouds.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
