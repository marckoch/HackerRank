package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CamelCaseTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("saveChangesInTheEditor");

        CamelCase.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }
}
