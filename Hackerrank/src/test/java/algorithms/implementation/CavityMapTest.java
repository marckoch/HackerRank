package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CavityMapTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("4",
                "1112",
                "1912",
                "1892",
                "1234");

        CavityMap.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1112",
                "1X12",
                "18X2",
                "1234");
    }
}
