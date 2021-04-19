package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class AshtonAndStringTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("1", "dbac", "3");

        AshtonAndString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("c");
    }
}
