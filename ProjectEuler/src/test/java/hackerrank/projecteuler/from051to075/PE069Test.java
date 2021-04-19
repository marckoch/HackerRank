package hackerrank.projecteuler.from051to075;

import java.math.BigInteger;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import toolbox.primes.GeneratePrimes;

/**
 *
 * @author marckoch
 */
public class PE069Test {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Test
    public void testFindMax() {
        long[] primes = GeneratePrimes.getFirstNPrimes(3000000);

        assertEquals(2, PE069.findMax(primes, BigInteger.valueOf(3)));
        assertEquals(6, PE069.findMax(primes, BigInteger.valueOf(10)));

        //assertEquals(6, PE069.findMax(primes, BigInteger.TEN.pow(17)));
    }

    @Test
    public void testMain() {
        systemInMock.provideLines("2", "3", "10");
        
        PE069.main(new String[]{});
        
        assertThat(sor.getLog(), is("2\n6\n"));
    }
}
