package algorithms.implementation;

import base.HackerrankTest;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BiggerIsGreaterTest extends HackerrankTest {

    @Test
    public void testMain() throws IOException {
        systemInMock.provideLines("5",
                "ab",
                "bb",
                "hefg",
                "dhck",
                "dkhc");

        BiggerIsGreater.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("ba",
                "no answer",
                "hegf",
                "dhkc",
                "hcdk");
    }
}
