package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class AlternatingCharactersTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5",
                "AAAA",
                "BBBBB",
                "ABABABAB",
                "BABABA",
                "AAABBB");

        AlternatingCharacters.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3",
                "4",
                "0",
                "0",
                "4");
    }
}
