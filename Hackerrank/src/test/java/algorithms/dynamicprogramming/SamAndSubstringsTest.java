package algorithms.dynamicprogramming;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SamAndSubstringsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("16");

        SamAndSubstrings.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("23");
    }
    
     @Test
    public void testMain2() {
        systemInMock.provideLines("123");

        SamAndSubstrings.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("164");
    }
}
