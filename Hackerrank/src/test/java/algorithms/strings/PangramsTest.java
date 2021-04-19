package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class PangramsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("We promptly judged antique ivory buckles for the next prize");

        Pangrams.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("pangram");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("We promptly judged antique ivory buckles for the prize");

        Pangrams.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("not pangram");
    }
}
