package algorithms.graphtheory;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class RoadsAndLibrariesTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "3 3 2 1",
                "1 2",
                "3 1",
                "2 3",
                "6 6 2 5",
                "1 3",
                "3 4",
                "2 4",
                "1 2",
                "2 3",
                "5 6");

        RoadsAndLibraries.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4", "12");
    }
}
