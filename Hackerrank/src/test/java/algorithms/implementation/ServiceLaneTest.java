package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ServiceLaneTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("8 5",
                "2 3 1 2 3 2 3 3",
                "0 3",
                "4 6",
                "6 7",
                "3 5",
                "0 7");

        ServiceLane.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1",
                "2",
                "3",
                "2",
                "1");
    }
}
