package hackerrank.projecteuler.from026to050;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class PE031Test {
 
    @Test
    public void testBuild() {
        PE031.build(20);
        //Assert.assertThat(PE031.ways[10], is(11));
        //Assert.assertThat(PE031.ways[15], is(22));
        //Assert.assertThat(PE031.ways[20], is(41));
    }
    
    @Test
    public void testBruteForce() {
        PE031.bruteForce(10);
        PE031.bruteForce(15);
        System.out.println(PE031.bruteForce(200));
    }
}
