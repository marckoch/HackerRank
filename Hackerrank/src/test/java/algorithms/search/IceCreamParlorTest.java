package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class IceCreamParlorTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "4",
                "5",
                "1 4 5 3 2",
                "4",
                "4",
                "2 2 4 3");

        IceCreamParlor.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 4",
                "1 2");
    }
}
