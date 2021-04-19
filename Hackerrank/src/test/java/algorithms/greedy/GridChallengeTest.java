package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class GridChallengeTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("1", "5",
                "ebacd",
                "fghij",
                "olmkn",
                "trpqs",
                "xywuv");

        GridChallenge.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES");
    }
}
