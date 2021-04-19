package hourrank.no24;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MutualIndivisibilityTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "1 3 2",
                "3 9 3",
                "2 5 4");

        MutualIndivisibility.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3 2",
                "9 8 7",
                "-1");
    }
}
