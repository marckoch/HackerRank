package hackerrank.projecteuler.from176to200;

import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marckoch
 */
public class PE199Test {

    @Test
    public void testSolveHackerrank1() {
        assertThat(String.valueOf(PE199.solveHackerrankInternal(3, 1)), startsWith("0.19813"));
    }

    @Test
    public void testSolveHackerrank2() {
        assertThat(String.valueOf(PE199.solveHackerrankInternal(3, 2)), startsWith("0.11413"));
    }

    @Test
    public void testSolveHackerrank3() {
        assertThat(String.valueOf(PE199.solveHackerrankInternal(3, 3)), startsWith("0.0679034"));
    }

    @Test
    public void testSolveHackerrank9() {
        assertThat(String.valueOf(PE199.solveHackerrankInternal(3, 9)), startsWith("0.0055053"));
    }
    
    @Test
    public void testSolveHackerrank10() {
        assertThat(String.valueOf(PE199.solveHackerrankInternal(3, 10)), startsWith("0.003960869"));
    }
    
    @Test
    public void testSolveHackerrank11() {
        assertThat(String.valueOf(PE199.solveHackerrankInternal(3, 11)), startsWith("0.0029147"));
    }
    
    @Test
    public void testSolveHackerrank3_3() {
        assertThat(String.valueOf(PE199.solveHackerrankInternal(3, 3)), startsWith("0.067903417174"));
    }
    
    @Test
    public void testSolveHackerrank4_1() {
        assertThat(String.valueOf(PE199.solveHackerrankInternal(4, 1)), startsWith("0.16652224137"));
    }
}
