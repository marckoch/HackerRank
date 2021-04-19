package hackerrank.projecteuler.from076to100;

import java.io.IOException;
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
public class PE087Test {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Test
    public void testSolveHackerrank1() throws IOException {
        systemInMock.provideLines("1", "50");

        PE087.solveHackerrank();

        assertThat(sor.getLog(), is("4\n"));
    }

    @Test
    public void testSolveHackerrank2() throws IOException {
        systemInMock.provideLines("2", "150", "5000");

        PE087.solveHackerrank();

        assertThat(sor.getLog(), is("17\n395\n"));
    }
}
