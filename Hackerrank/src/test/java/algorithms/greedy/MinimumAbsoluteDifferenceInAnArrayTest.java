package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MinimumAbsoluteDifferenceInAnArrayTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "3 -7 0");

        MinimumAbsoluteDifferenceInAnArray.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
