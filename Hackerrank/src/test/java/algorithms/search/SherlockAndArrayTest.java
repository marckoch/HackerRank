package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SherlockAndArrayTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "3",
                "1 2 3",
                "4",
                "1 2 3 3");

        SherlockAndArray.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("NO", "YES");
    }
}
