package hackerrank.projecteuler.from051to075;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 *
 * @author marckoch
 */
public class PE074Test {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Test
    public void testFindLoopLength() {
        assertThat(PE074.findLoopLength(1), is(1));
        assertThat(PE074.findLoopLength(2), is(1));
        assertThat(PE074.findLoopLength(145), is(1));

        assertThat(PE074.findLoopLength(0), is(2));
        assertThat(PE074.findLoopLength(10), is(2));
        assertThat(PE074.findLoopLength(11), is(2));
        assertThat(PE074.findLoopLength(154), is(2));
        assertThat(PE074.findLoopLength(540), is(2));

        assertThat(PE074.findLoopLength(871), is(2));
        assertThat(PE074.findLoopLength(872), is(2));

        assertThat(PE074.findLoopLength(169), is(3));

        assertThat(PE074.findLoopLength(78), is(4));
        assertThat(PE074.findLoopLength(87), is(4));
        assertThat(PE074.findLoopLength(196), is(4));
        assertThat(PE074.findLoopLength(961), is(4));
        assertThat(PE074.findLoopLength(236), is(4));

        assertThat(PE074.findLoopLength(24), is(7));
        assertThat(PE074.findLoopLength(42), is(7));
        assertThat(PE074.findLoopLength(104), is(7));
        assertThat(PE074.findLoopLength(114), is(7));
        assertThat(PE074.findLoopLength(140), is(7));
        assertThat(PE074.findLoopLength(141), is(7));

        assertThat(PE074.findLoopLength(4), is(8));
        assertThat(PE074.findLoopLength(27), is(8));
        assertThat(PE074.findLoopLength(39), is(8));
        assertThat(PE074.findLoopLength(72), is(8));
        assertThat(PE074.findLoopLength(93), is(8));
        assertThat(PE074.findLoopLength(107), is(8));
        assertThat(PE074.findLoopLength(117), is(8));
        assertThat(PE074.findLoopLength(170), is(8));
        assertThat(PE074.findLoopLength(171), is(8));

        assertThat(PE074.findLoopLength(40585), is(1));

        assertThat(PE074.findLoopLength(5044), is(4));

        assertThat(PE074.findLoopLength(1454), is(3));
        assertThat(PE074.findLoopLength(1445), is(4));
    }

    @Test
    public void testSolveHackerrankPreCalc() {
        systemInMock.provideLines("10",
                "221 7",
                "147 1",
                "258 4",
                "265 8",
                "210 2",
                "175 7",
                "29 2",
                "24 3",
                "273 4",
                "261 4");

        PE074.solveHackerrankPreCalc();

        assertThat(sor.getLog(), is("24 42 104 114 140 141\n"
                + "1 2 145\n"
                + "78 87 196 236\n"
                + "4 27 39 72 93 107 117 170 171\n"
                + "0 10 11 154\n"
                + "24 42 104 114 140 141\n"
                + "0 10 11\n"
                + "-1\n"
                + "78 87 196 236 263\n"
                + "78 87 196 236\n"));
    }

}
