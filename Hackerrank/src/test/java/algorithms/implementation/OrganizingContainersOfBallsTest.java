package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */

public class OrganizingContainersOfBallsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("2",
                "2",
                "1 1",
                "1 1",
                "2",
                "0 2",
                "1 1");

        OrganizingContainersOfBalls.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Possible",
                "Impossible");
    }

    @Test
    public void testMain1() {
        systemInMock.provideLines("1", "2",
                "999336263 998799923",
                "998799923 999763019");

        OrganizingContainersOfBalls.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Possible");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("1", "2",
                "999789250 999886349",
                "999654053 999789250");

        OrganizingContainersOfBalls.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Possible");
    }
}
