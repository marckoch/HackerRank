package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class DayOfTheProgrammerTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2017");

        DayOfTheProgrammer.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("13.09.2017");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("2016");

        DayOfTheProgrammer.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("12.09.2016");
    }
}
