package algorithms.strings;

import base.HackerrankTest;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class GridlandProvincesTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "1",
                "a",
                "a",
                "3",
                "dab",
                "abd",
                "5",
                "ababa",
                "babab");

        GridlandProvinces.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1", "8", "2");
    }
}
