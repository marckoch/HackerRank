package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FunnyStringTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "acxz",
                "bcxz");

        FunnyString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Funny",
                "Not Funny");
    }
}
