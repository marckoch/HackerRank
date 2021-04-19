package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FlatlandSpaceStationsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("5 2", "0 4");

        FlatlandSpaceStations.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }
}
