package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class GemstonesTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "abcdde",
                "baccd",
                "eeabg");

        Gemstones.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }
}
