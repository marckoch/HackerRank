package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class AppendAndDeleteTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("hackerhappy", "hackerrank", "9");

        AppendAndDelete.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Yes");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("aba", "aba", "7");

        AppendAndDelete.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Yes");
    }
}
