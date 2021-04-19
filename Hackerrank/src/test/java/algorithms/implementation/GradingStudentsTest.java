package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class GradingStudentsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("4", "73", "67", "38", "33");

        GradingStudents.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("75",
                "67",
                "40",
                "33");
    }
}
