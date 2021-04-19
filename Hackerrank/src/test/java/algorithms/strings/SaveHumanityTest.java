package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SaveHumanityTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "abbab ba",
                "hello world",
                "banana nan");

        SaveHumanity.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 2",
                "No Match!",
                "0 2");
    }
}
