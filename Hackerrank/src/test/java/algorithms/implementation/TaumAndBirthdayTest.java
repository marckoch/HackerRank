package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class TaumAndBirthdayTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("5",
                "10 10",
                "1 1 1",
                "5 9",
                "2 3 4",
                "3 6",
                "9 1 1",
                "7 7",
                "4 2 1",
                "3 3",
                "1 9 2");

        TaumAndBirthday.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("20",
                "37",
                "12",
                "35",
                "12");
    }
}
