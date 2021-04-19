package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class HackerlandRadioTransmittersTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5 1",
                "1 2 3 4 5");

        HackerlandRadioTransmitters.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }
    
    @Test
    public void testMain2() {
        systemInMock.provideLines("8 2",
                "7 2 4 6 5 9 12 11 ");

        HackerlandRadioTransmitters.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }
}
