package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CaesarCipherTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("11", "middle-Outz", "2");

        CaesarCipher.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("okffng-Qwvb");
    }
}
