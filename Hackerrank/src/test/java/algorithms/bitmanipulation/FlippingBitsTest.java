package algorithms.bitmanipulation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FlippingBitsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "2147483647",
                "1",
                "0");

        FlippingBits.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2147483648",
                "4294967294",
                "4294967295");
    }
}
