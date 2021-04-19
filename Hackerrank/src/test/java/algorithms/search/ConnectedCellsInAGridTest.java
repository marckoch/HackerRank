package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ConnectedCellsInAGridTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4",
                "4",
                "1 1 0 0",
                "0 1 1 0",
                "0 0 1 0",
                "1 0 0 0");

        ConnectedCellsInAGrid.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }
}
