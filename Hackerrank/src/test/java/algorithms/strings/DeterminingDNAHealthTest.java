package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class DeterminingDNAHealthTest extends HackerrankTest {

    @Test
    public void testMain1() throws Exception {
        systemInMock.provideLines("6",
                "a b c aa d b",
                "1 2 3 4 5 6",
                "3",
                "1 5 caaab",
                "0 4 xyz",
                "2 4 bcdybc");

        DeterminingDNAHealthUwi.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0 19");
    }
}
