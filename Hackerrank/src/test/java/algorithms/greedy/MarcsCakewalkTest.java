package algorithms.greedy;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MarcsCakewalkTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3", "1 3 2");

        MarcsCakewalk.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("11");
    }

    @Test
    public void testcase4() {
        systemInMock.provideLines("20", "353 726 36 574 234 746 507 244 382 349 107 279 608 87 459 793 710 73 758 945");

        MarcsCakewalk.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("73444139");
    }
}
