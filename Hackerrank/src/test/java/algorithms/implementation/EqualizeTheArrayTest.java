package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class EqualizeTheArrayTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("5", "3 3 2 1 3");

        EqualizeTheArray.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }
}
