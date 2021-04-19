package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class KangarooTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("0 3 4 2");

        Kangaroo.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("0 2 5 3");

        Kangaroo.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("NO");
    }
}
