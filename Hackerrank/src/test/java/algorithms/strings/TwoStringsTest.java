package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class TwoStringsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "hello",
                "world",
                "hi",
                "world");

        TwoStrings.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES", "NO");
    }
}
