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
public class PE083Test {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Test
    public void testSolveBFS() {
        long result = PE083.solveBFS(new long[][]{
            {3, 4},
            {1, 7}});
        assertThat(result, is(11L));

        result = PE083.solveBFS(new long[][]{
            {13, 2, 3},
            {1, 4, 5},
            {2, 8, 3}});
        assertThat(result, is(26L));

        result = PE083.solveBFS(new long[][]{
            {131, 673, 234, 103, 18},
            {201, 96, 342, 965, 150},
            {630, 803, 746, 422, 111},
            {537, 699, 497, 121, 956},
            {805, 732, 524, 37, 331}});
        assertThat(result, is(2297L));
    }

    @Test
    public void testSolveHackerrankWith2DimArray() throws IOException {
        systemInMock.provideLines("2", "3 4 1 7");

        PE083.solveHackerrank();

        assertThat(sor.getLog(), is("11\n"));
    }
    
    @Test
    public void testSolveHackerrankWith5DimArray() throws IOException {
        systemInMock.provideLines("5",
                "131 673 234 103 18",
                "201 96 342 965 150",
                "630 803 746 422 111",
                "537 699 497 121 956",
                "805 732 524 37 331");

        PE083.solveHackerrank();

        assertThat(sor.getLog(), is("2297\n"));
    }
}
