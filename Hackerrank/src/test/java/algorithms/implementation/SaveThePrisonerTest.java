package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class SaveThePrisonerTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("2", "5 2 1", "5 2 2");

        SaveThePrisoner.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2","3");
    }
}
