package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MaximumPerimeterTriangleTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5",
                "1 1 1 3 3");

        MaximumPerimeterTriangle.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 3 3");
    }
    
    @Test
    public void testMain2() {
        systemInMock.provideLines("3",
                "1 2 3");

        MaximumPerimeterTriangle.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("-1");
    }
}
