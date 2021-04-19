package hackerrank.projecteuler.from076to100;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marckoch
 */
public class PE078Test {
    
    @Test
    public void testPentagonal() {
        assertThat(PE078.pentagonal(1), is(1));
        assertThat(PE078.pentagonal(-1), is(2));
        assertThat(PE078.pentagonal(2), is(5));
        assertThat(PE078.pentagonal(-2), is(7));
        assertThat(PE078.pentagonal(3), is(12));
        assertThat(PE078.pentagonal(-3), is(15));
    }
    
}
