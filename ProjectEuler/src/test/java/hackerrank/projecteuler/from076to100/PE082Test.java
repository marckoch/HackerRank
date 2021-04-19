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
public class PE082Test {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Test
    public void testSolve() {
        long result = PE082.solve(new long[][]{
            {3, 4},
            {1, 7}});
        assertThat(result, is(7L));

        result = PE082.solve(new long[][]{
            {13, 2, 3},
            {1, 4, 5},
            {2, 8, 3}});
        assertThat(result, is(10L));

        result = PE082.solve(new long[][]{
            {131, 673, 234, 103, 18},
            {201, 96, 342, 965, 150},
            {630, 803, 746, 422, 111},
            {537, 699, 497, 121, 956},
            {805, 732, 524, 37, 331}});
        assertThat(result, is(994L));
    }
    
    @Test
    public void testSolveBFS() {
        long result = PE082.solveBFS(new long[][]{
            {3, 4},
            {1, 7}});
        assertThat(result, is(7L));

        result = PE082.solveBFS(new long[][]{
            {13, 2, 3},
            {1, 4, 5},
            {2, 8, 3}});
        assertThat(result, is(10L));

        result = PE082.solveBFS(new long[][]{
            {131, 673, 234, 103, 18},
            {201, 96, 342, 965, 150},
            {630, 803, 746, 422, 111},
            {537, 699, 497, 121, 956},
            {805, 732, 524, 37, 331}});
        assertThat(result, is(994L));
    }

    @Test
    public void testSolveHackerrankWith2DimArray() throws IOException {
        systemInMock.provideLines("2", "3 4 1 7");

        PE082.solveHackerrank();

        assertThat(sor.getLog(), is("7\n"));
    }
    
    @Test
    public void testSolveHackerrankWith5DimArray() throws IOException {
        systemInMock.provideLines("5",
                "131 673 234 103 18",
                "201 96 342 965 150",
                "630 803 746 422 111",
                "537 699 497 121 956",
                "805 732 524 37 331");

        PE082.solveHackerrank();

        assertThat(sor.getLog(), is("994\n"));
    }
}
