package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CutTheTreeTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6",
                "100 200 100 500 100 600",
                "1 2",
                "2 3",
                "2 5",
                "4 5",
                "5 6");

        CutTheTree.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("400");
    }
}
