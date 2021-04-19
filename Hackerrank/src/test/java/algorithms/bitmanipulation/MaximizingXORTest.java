package algorithms.bitmanipulation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MaximizingXORTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("10", "15");

        MaximizingXOR.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("7");
    }

    @Test
    public void testcase10() {
        systemInMock.provideLines("162", "278");

        MaximizingXOR.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("511");
    }

    @Test
    public void testcase12() {
        systemInMock.provideLines("5", "7");

        MaximizingXOR.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
