package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BeautifulQuadruplesTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("1 2 3 4");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("11");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("4 3 2 1");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("11");
    }
    
    @Test
    public void testMain3() {
        systemInMock.provideLines("10 10 10 10");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("644");
    }

    @Test
    public void testcase1() {
        systemInMock.provideLines("1150 1547 853 423");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("127535297312");
    }

    @Test
    public void testcase2() {
        systemInMock.provideLines("1951 2709 1793 129");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("317714055759");
    }

    @Test
    public void testcase3() {
        systemInMock.provideLines("2047 1927 360 896");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("301271960180");
    }

    @Test
    public void testcase4() {
        systemInMock.provideLines("1929 2923 2824 1706");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2666133769916");
    }

    @Test
    public void testcase5() {
        systemInMock.provideLines("3000 3000 3000 3000");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3380895410799");
    }

    @Test
    public void testcase7() {
        systemInMock.provideLines("1 1 1 1");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }

    @Test
    public void testcase8() {
        systemInMock.provideLines("50 50 50 50");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("287736");
    }

        @Test
    public void testcase10() {
        systemInMock.provideLines("41 43 44 48");

        BeautifulQuadruples.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("234686");
    }
    
}
