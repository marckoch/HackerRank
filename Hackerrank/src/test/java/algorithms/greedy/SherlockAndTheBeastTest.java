package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SherlockAndTheBeastTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4",
                "1",
                "3",
                "5",
                "11");

        SherlockAndTheBeast.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("-1",
                "555",
                "33333",
                "55555533333");
    }
}
