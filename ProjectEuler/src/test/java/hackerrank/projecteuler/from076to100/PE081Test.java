package hackerrank.projecteuler.from076to100;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 *
 * @author marckoch
 */
public class PE081Test {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Test
    public void testSolve() {
        long result = PE081.solve(new long[][]{
            {3, 4},
            {1, 7}});
        assertThat(result, is(11L));

        result = PE081.solve(new long[][]{
            {3, 4, 3},
            {1, 7, 5},
            {2, 8, 3}});
        assertThat(result, is(17L));

        result = PE081.solve(new long[][]{
            {131, 673, 234, 103, 18},
            {201, 96, 342, 965, 150},
            {630, 803, 746, 422, 111},
            {537, 699, 497, 121, 956},
            {805, 732, 524, 37, 331}});
        assertThat(result, is(2427L));
    }

    @Test
    public void testSolveBFS() {
        long result = PE081.solveBFS(new long[][]{
            {3, 4},
            {1, 7}});
        assertThat(result, is(11L));

        result = PE081.solveBFS(new long[][]{
            {3, 4, 3},
            {1, 7, 5},
            {2, 8, 3}});
        assertThat(result, is(17L));

        result = PE081.solveBFS(new long[][]{
            {131, 673, 234, 103, 18},
            {201, 96, 342, 965, 150},
            {630, 803, 746, 422, 111},
            {537, 699, 497, 121, 956},
            {805, 732, 524, 37, 331}});
        assertThat(result, is(2427L));
    }
    
//    @Test
//    public void testMain() throws IOException {
//        String givenInput = "2\r\n 3 4 1 7\r\n";
//        String expectedOutput = "4\n";
//
//        // remember original streams
//        InputStream origStdIn = System.in;
//        PrintStream origStdOut = System.out;
//
//        try {
//            // redirected stdin to given input string
//            System.setIn(new ByteArrayInputStream(givenInput.getBytes()));
//            
//            // redirect stdout to capture output from main method
//            ByteArrayOutputStream outputCapture = new ByteArrayOutputStream();
//            System.setOut(new PrintStream(outputCapture));
//            
//            PE082.main(new String[]{});
//            
//            System.out.flush();
//            assertThat(outputCapture.toString(), is(expectedOutput));
//        } finally {
//            // restore original streams
//            System.setIn(origStdIn);
//            System.setOut(origStdOut);
//        }
//    }
    @Test
    public void testSolveHackerrankWith2DimArray() throws IOException {
        systemInMock.provideLines("2", "3 4 1 7");

        PE081.solveHackerrank();

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

        PE081.solveHackerrank();

        assertThat(sor.getLog(), is("2427\n"));
    }
}
