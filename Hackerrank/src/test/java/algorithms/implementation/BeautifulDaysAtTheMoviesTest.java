package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BeautifulDaysAtTheMoviesTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("20 23 6");

        BeautifulDaysAtTheMovies.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }

}
