package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CatsAndAMouseTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("3", "1 2 3", "1 3 2", "2 1 3");

        CatsAndAMouse.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Cat B",
                "Mouse C",
                "Cat A");
    }
}
