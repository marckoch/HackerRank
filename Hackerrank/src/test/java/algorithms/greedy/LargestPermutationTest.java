package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class LargestPermutationTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5 1", "4 2 3 5 1");

        LargestPermutation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5 2 3 4 1");
    }
    
     @Test
    public void testMain2() {
        systemInMock.provideLines("3 1", "2 1 3");

        LargestPermutation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3 1 2");
    }
}
