package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CommonChildTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("HARRY",
                "SALLY");

        CommonChild.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("AA",
                "BB");

        CommonChild.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("SHINCHAN",
                "NOHARAAA");

        CommonChild.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }

    @Test
    public void testMain4() {
        systemInMock.provideLines("ABCDEF",
                "FBDAMN");

        CommonChild.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }
}
