package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class AngryProfessorTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("2",
                "4 3",
                "-1 -3 4 2",
                "4 2",
                "0 -1 2 1");

        AngryProfessor.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES", "NO");
    }
}
