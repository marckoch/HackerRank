package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FairRationsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5", "2 3 4 5 6");

        FairRations.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }
    
    @Test
    public void testMain2() {
        systemInMock.provideLines("2", "1 2");

        FairRations.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("NO");
    }
}
