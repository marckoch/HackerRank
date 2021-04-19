package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class LilysHomeworkTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4", "2 5 3 1");

        LilysHomework.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }
}
