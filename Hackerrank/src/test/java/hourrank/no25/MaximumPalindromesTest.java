package hourrank.no25;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MaximumPalindromesTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("abab",
                "1",
                "1 4");

        MaximumPalindromes.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("week",
                "2",
                "1 4",
                "2 3");

        MaximumPalindromes.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2", "1");
    }
    
    @Test
    public void testMain3() {
        systemInMock.provideLines("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj",
                "1",
                "5 44");

        MaximumPalindromes.main(null);

        System.err.println(ser.getLog());
        
        assertThatSystemOutEqualsIgnoreWhiteSpace("1");
    }
}
