package hackerrank.projecteuler.from051to075;

import hackerrank.projecteuler.from051to075.PE064;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class PE064Test {
 
    @Test
    public void testCount() {
        Assert.assertThat(PE064.count(13), is(4));
    }
    
    @Test
    public void testGetPeriodLength() {
        Assert.assertThat(PE064.getPeriodLength(2), is(1));
        Assert.assertThat(PE064.getPeriodLength(3), is(2));
        Assert.assertThat(PE064.getPeriodLength(5), is(1));
        Assert.assertThat(PE064.getPeriodLength(6), is(2));
        Assert.assertThat(PE064.getPeriodLength(7), is(4));
        Assert.assertThat(PE064.getPeriodLength(8), is(2));
        Assert.assertThat(PE064.getPeriodLength(10), is(1));
        Assert.assertThat(PE064.getPeriodLength(11), is(2));
        Assert.assertThat(PE064.getPeriodLength(12), is(2));
        Assert.assertThat(PE064.getPeriodLength(13), is(5));
    }
    
    @Test
    public void testGetPeriodLength23() {
        Assert.assertThat(PE064.getPeriodLength(23), is(4));
    }
}
