package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class LuckBalanceTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6 3",
                "5 1",
                "2 1",
                "1 1",
                "8 1",
                "10 0",
                "5 0");

        LuckBalance.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("29");
    }
}
