package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SuperReducedStringTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("aaabccddd");

        SuperReducedString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("abd");
    }
    
    @Test
    public void testMain2() {
        systemInMock.provideLines("baab");

        SuperReducedString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Empty String");
    }
    
    @Test
    public void testMain3() {
        systemInMock.provideLines("aa");

        SuperReducedString.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Empty String");
    }
}
