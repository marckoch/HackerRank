package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MakingAnagramsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("cde", "abc");

        MakingAnagrams.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }
}
