package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CorrectnessAndTheLoopInvariantTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6",
                "1 4 3 5 6 2");

        CorrectnessAndTheLoopInvariant.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 2 3 4 5 6");
    }
}
