package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class KnightLOnAChessboardTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5");

        KnightLOnAChessboard.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4 4 2 8",
                "4 2 4 4",
                "2 4 -1 -1",
                "8 4 -1 1");
    }
}
