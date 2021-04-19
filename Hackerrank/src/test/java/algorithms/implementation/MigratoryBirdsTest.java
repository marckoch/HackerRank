package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MigratoryBirdsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("6", "1 4 4 4 5 3");

        MigratoryBirds.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }
}
