package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class HappyLadybugsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("4",
                "7",
                "RBY_YBR",
                "6",
                "X_Y__X",
                "2",
                "__",
                "6",
                "B_RRBR");

        HappyLadybugs.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES",
                "NO",
                "YES",
                "YES");
    }
}
