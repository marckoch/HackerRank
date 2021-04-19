package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class TheHurdleRaceTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5 4", "1 6 3 5 2");

        TheHurdleRace.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5 7", "2 5 4 5 2");

        TheHurdleRace.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }

}
