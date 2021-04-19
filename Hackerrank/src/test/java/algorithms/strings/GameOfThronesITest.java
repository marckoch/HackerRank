package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class GameOfThronesITest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("aaabbbb");

        GameOfThronesI.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES");
    }
    
    @Test
    public void testMain2() {
        systemInMock.provideLines("cdefghmnopqrstuvw");

        GameOfThronesI.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("NO");
    }
    
     @Test
    public void testMain3() {
        systemInMock.provideLines("cdcdcdcdeeeef");

        GameOfThronesI.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES");
    }
}
