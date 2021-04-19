package algorithms.strings;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class RichieRichTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4 1",
                "3943");

        RichieRich.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3993");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("6 3",
                "092282");

        RichieRich.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("992299");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("3 0",
                "777");

        RichieRich.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("777");
    }

    @Test
    public void testMain4() {
        systemInMock.provideLines("4 1",
                "0011");

        RichieRich.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("-1");
    }
    
    @Test
    public void testMain5() {
        systemInMock.provideLines("6 3",
                "91931919");

        RichieRich.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("99933999");
    }
}
