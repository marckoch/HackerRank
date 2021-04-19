package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class LarrysArrayTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("3",
                "3",
                "3 1 2",
                "4",
                "1 3 4 2",
                "5",
                "1 2 3 5 4");

        LarrysArray.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES",
                "YES",
                "NO");
    }
}
