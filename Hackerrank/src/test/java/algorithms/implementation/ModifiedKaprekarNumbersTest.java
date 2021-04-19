package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ModifiedKaprekarNumbersTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("1", "100");

        ModifiedKaprekarNumbers.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 9 45 55 99");
    }
}
