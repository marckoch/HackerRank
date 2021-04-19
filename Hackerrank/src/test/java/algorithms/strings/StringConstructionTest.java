package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class StringConstructionTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2", "abcd", "abab");

        StringConstruction.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4", "2");
    }
}
