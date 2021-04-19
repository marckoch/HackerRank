package algorithms.dynamicprogramming;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FibonacciModifiedTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("0 1 5");

        FibonacciModified.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }
    
    @Test
    public void testcase8() {
        systemInMock.provideLines("1 1 9");

        FibonacciModified.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("84266613096281243382112");
    }
    
    @Test
    public void testcase9() {
        systemInMock.provideLines("2 1 7");

        FibonacciModified.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("112763264");
    }
}
