package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class JimAndTheOrdersTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "1 3",
                "2 3",
                "3 3");

        JimAndTheOrders.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 2 3");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5",
                "8 1",
                "4 2",
                "5 6",
                "3 1",
                "4 3");

        JimAndTheOrders.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4 2 5 1 3");
    }
}
