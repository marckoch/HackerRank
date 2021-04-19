package hackerrank.projecteuler.from076to100;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marckoch
 */
public class PE080Test {

    public PE080Test() {
    }

    @Test
    public void testSolve() {
        assertThat(PE080.solve(2, 100), is(475L));
        assertThat(PE080.solve(100, 100), is(40886L));
        assertThat(PE080.solve(1000, 1000), is(4359087L));
        assertThat(PE080.solve(100, 10000), is(4048597L));
    }

}
