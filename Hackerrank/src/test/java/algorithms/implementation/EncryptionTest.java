package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class EncryptionTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("haveaniceday");

        Encryption.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("hae and via ecy ");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("feedthedog");

        Encryption.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("fto ehg ee dd ");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("chillout");

        Encryption.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("clu hlt io ");
    }
}
