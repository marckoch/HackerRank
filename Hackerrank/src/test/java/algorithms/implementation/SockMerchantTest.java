package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SockMerchantTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("9", "10 20 20 10 10 30 50 10 20");

        SockMerchant.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }

}
