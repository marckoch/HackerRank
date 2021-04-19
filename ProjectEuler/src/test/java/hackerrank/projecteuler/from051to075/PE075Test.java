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
public class PE075Test {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Test
    public void testSolveHackerrank() {
        systemInMock.provideLines("2", "12", "50");

        PE075.solveHackerrank();
        
        assertThat(sor.getLog(), is("1\n6\n"));
    }
    
    @Test
    public void testSolveProjectEuler() {
        assertThat(PE075.solveProjectEuler(), is(161667));
    }

}
