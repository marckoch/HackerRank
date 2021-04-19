package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class QueensAttack2Test extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4 0", "4 4");

        QueensAttack2.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("9");
    }
    
        @Test
    public void testMain2() {
        systemInMock.provideLines("5 3", "4 3", "5 5", "4 2", "2 3");

        QueensAttack2.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("10");
    }
}
