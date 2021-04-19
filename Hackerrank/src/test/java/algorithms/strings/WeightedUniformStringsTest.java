package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class WeightedUniformStringsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("abccddde",
                "6",
                "1",
                "3",
                "12",
                "5",
                "9",
                "10");

        WeightedUniformStrings.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Yes",
                "Yes",
                "Yes",
                "Yes",
                "No",
                "No");
    }
}
