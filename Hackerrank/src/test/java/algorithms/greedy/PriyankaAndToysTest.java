package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class PriyankaAndToysTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5",
                "1 2 3 17 10");

        PriyankaAndToys.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
