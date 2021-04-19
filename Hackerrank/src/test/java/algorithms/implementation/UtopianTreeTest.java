package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class UtopianTreeTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("3\n"
                + "0\n"
                + "1\n"
                + "4");

        UtopianTree.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1", "2", "7");
    }
}
