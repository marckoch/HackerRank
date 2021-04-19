package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class LisasWorkbookTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("5 3", "4 2 6 1 10");

        LisasWorkbook.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }
}
