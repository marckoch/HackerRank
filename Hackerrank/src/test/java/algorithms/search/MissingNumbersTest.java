package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MissingNumbersTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("10",
                "203 204 205 206 207 208 203 204 205 206",
                "13",
                "203 204 204 205 206 207 205 208 203 206 205 206 204");

        MissingNumbers.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("204 205 206");
    }
}
