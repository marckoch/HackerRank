package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ExtraLongFactorialsTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("25");

        ExtraLongFactorials.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("15511210043330985984000000");
    }
}
