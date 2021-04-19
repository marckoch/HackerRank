package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class TheBombermanGameTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("6 7 1",
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO.....");

        TheBombermanGame.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace(".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO.....");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("6 7 2",
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO.....");

        TheBombermanGame.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("6 7 3",
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO.....");

        TheBombermanGame.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace(
                "OOO.OOO",
                "OO...OO",
                "OOO...O",
                "..OO.OO",
                "...OOOO",
                "...OOOO");
    }
    
    @Test
    public void testMain4() {
        systemInMock.provideLines("6 7 4",
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO.....");

        TheBombermanGame.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace(
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO",
                "OOOOOOO");
    }
    
    @Test
    public void testMain5() {
        systemInMock.provideLines("6 7 5",
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO.....");

        TheBombermanGame.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace(
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO.....");
    }
}
