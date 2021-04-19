package algorithms.strings;

import base.HackerrankTest;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SherlockAndTheValidStringTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("aabbcd");

        SherlockAndTheValidString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("NO");
    }

    @Test
    public void testMainInput9() throws IOException {
        mockStdInFromTestFile("input09.txt");

        SherlockAndTheValidString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("NO");
    }

    @Test
    public void testMainInput12() throws IOException {
        mockStdInFromTestFile("input12.txt");

        SherlockAndTheValidString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES");
    }
}
