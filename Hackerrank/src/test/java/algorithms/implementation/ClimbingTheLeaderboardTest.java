package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ClimbingTheLeaderboardTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("7", "100 100 50 40 40 20 10", "4", "5 25 50 120");

        ClimbingTheLeaderboard.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("6",
                "4",
                "2",
                "1");
    }
}
