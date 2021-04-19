package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class EmasSupercomputerTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5 6",
                "GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG");

        EmasSupercomputer.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("6 6",
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "GGGGGG",
                "BGBBGB",
                "BGBBGB");

        EmasSupercomputer.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("25");
    }

    @Test
    public void testMain06() {
        systemInMock.provideLines("8 9",
                "GGGGGGGGG",
                "GBBBGGBGG",
                "GBBBGGBGG",
                "GBBBGGBGG",
                "GBBBGGBGG",
                "GBBBGGBGG",
                "GBBBGGBGG",
                "GGGGGGGGG");

        EmasSupercomputer.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1");
    }

}
