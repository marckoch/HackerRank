package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class NonDivisibleSubsetTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("4 3" ,"1 7 2 4");

        NonDivisibleSubset.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
