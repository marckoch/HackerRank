package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class TwoCharactersTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("10", "beabeefeab");

        TwoCharacters.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }
}
