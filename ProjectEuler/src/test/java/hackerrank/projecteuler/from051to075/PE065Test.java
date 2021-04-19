package hackerrank.projecteuler.from051to075;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marckoch
 */
public class PE065Test {
    
    @Test
    public void testGetPeriodLength() {
        assertThat(PE065.getConvergenceNumber(2), is(1));
        assertThat(PE065.getConvergenceNumber(3), is(2));
        assertThat(PE065.getConvergenceNumber(4), is(1));
        assertThat(PE065.getConvergenceNumber(5), is(1));
        assertThat(PE065.getConvergenceNumber(6), is(4));
        assertThat(PE065.getConvergenceNumber(7), is(1));
        assertThat(PE065.getConvergenceNumber(8), is(1));
        assertThat(PE065.getConvergenceNumber(9), is(6));
    }
    
    @Test
    public void testExpand() {
        assertArrayEquals(new long[]{3, 2}, PE065.expand(1, new long[]{1, 2}));
        assertArrayEquals(new long[]{5, 2}, PE065.expand(2, new long[]{1, 2}));
        assertArrayEquals(new long[]{4, 3}, PE065.expand(1, new long[]{1, 3}));
        assertArrayEquals(new long[]{5, 3}, PE065.expand(1, new long[]{2, 3}));
        assertArrayEquals(new long[]{(17*13+11), 13}, PE065.expand(17, new long[]{11, 13}));
    }
    
    @Test
    public void testGetConvergent() {
        assertArrayEquals(new long[]{2, 1}, PE065.getConvergent(1));
        assertArrayEquals(new long[]{3, 1}, PE065.getConvergent(2));
        assertArrayEquals(new long[]{8, 3}, PE065.getConvergent(3));
        assertArrayEquals(new long[]{11, 4}, PE065.getConvergent(4));
        assertArrayEquals(new long[]{19, 7}, PE065.getConvergent(5));
        assertArrayEquals(new long[]{87, 32}, PE065.getConvergent(6));
        assertArrayEquals(new long[]{106, 39}, PE065.getConvergent(7));
        assertArrayEquals(new long[]{193, 71}, PE065.getConvergent(8));
        assertArrayEquals(new long[]{1264, 465}, PE065.getConvergent(9));
        assertArrayEquals(new long[]{1457, 536}, PE065.getConvergent(10));
    }
    
    @Test
    public void testGetDigitSumOfTop() {
        assertThat(PE065.getDigitSumOfTop(1), is(2L));
        assertThat(PE065.getDigitSumOfTop(2), is(3L));
        assertThat(PE065.getDigitSumOfTop(3), is(8L));
        assertThat(PE065.getDigitSumOfTop(4), is(2L));
        assertThat(PE065.getDigitSumOfTop(5), is(10L));
        assertThat(PE065.getDigitSumOfTop(6), is(15L));
        assertThat(PE065.getDigitSumOfTop(7), is(7L));
        assertThat(PE065.getDigitSumOfTop(8), is(13L));
        assertThat(PE065.getDigitSumOfTop(9), is(13L));
        assertThat(PE065.getDigitSumOfTop(10), is(17L));
        
    }
}
