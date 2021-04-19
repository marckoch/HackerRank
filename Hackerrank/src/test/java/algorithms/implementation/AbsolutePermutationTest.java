package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class AbsolutePermutationTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("3",
                "2 1",
                "3 0",
                "3 2");

        AbsolutePermutation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2 1",
                "1 2 3",
                "-1");
    }
}
