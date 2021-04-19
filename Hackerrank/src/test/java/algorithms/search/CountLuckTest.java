package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CountLuckTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3",
                "2 3",
                "*.M",
                ".X.",
                "1",
                "4 11",
                ".X.X......X",
                ".X*.X.XXX.X",
                ".XX.X.XM...",
                "......XXXX.",
                "3",
                "4 11",
                ".X.X......X",
                ".X*.X.XXX.X",
                ".XX.X.XM...",
                "......XXXX.",
                "4");

        CountLuck.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Impressed",
                "Impressed",
                "Oops!");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5",
                "3 6",
                "*.M...",
                ".X.X.X",
                "XXX...",
                "1",
                "3 6",
                "*..M..",
                ".X.X.X",
                "XXX...",
                "2",
                "3 6",
                "*M....",
                ".X.X.X",
                "XXX...",
                "1",
                "3 6",
                "*....M",
                ".X.X.X",
                "XXX...",
                "2",
                "3 6",
                "*.....",
                ".X.X.X",
                "XXX.M.",
                "3");

        CountLuck.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Impressed",
                "Impressed", "Impressed", "Impressed", "Impressed");
    }

    @Test
    public void testcase4_6() {
        systemInMock.provideLines("1",
                "41 41",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                "M........................................",
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".*.......................................",
                "280");

        CountLuck.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Impressed");
    }

    @Test
    public void testcase2_6() {
        systemInMock.provideLines("1",
                "41 41",
                ".X.XXXXXXXXXXXXXXXXXXX.X.X.X.X.X.X.X.X.X.",
                "...XXXXXXXXXXXXXXXXXXX...................",
                ".X..X.X.X.X.X.X.X..XXXX*X.X.X.X.X.X.X.XX.",
                ".XXXX.X.X.X.X.X.X.XX.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".XX.X.X.X.XX.X.XX.X.X.X.X.X.X.X.X.X.X.X.X",
                ".X.X.X.X.X.XXX.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                "X........................................",
                "X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                ".X.XX.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XX.XX",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XMX.",
                ".X....................................X..",
                "..X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".X...................................X...",
                ".XX.X.X.X.X.X.X.X.X.X.X.X.X.X.XX.XX.XXXX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.XX.",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                ".........................................",
                "294");

        CountLuck.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("Impressed");
    }
}
