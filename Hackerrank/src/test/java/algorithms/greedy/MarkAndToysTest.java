package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MarkAndToysTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("7 50", "1 12 5 111 200 1000 10");

        MarkAndToys.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }
}
