package toolbox.root;

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import static toolbox.root.ContinuedFraction.divide;

/**
 *
 * @author marckoch
 */
public class ContinuedFractionTest {
    
    public ContinuedFractionTest() {
    }

    @Test
    public void testDivide() {
        assertArrayEquals(new BigInteger[]{BigInteger.TEN, BigInteger.ONE}, 
                divide(1, new BigInteger[]{BigInteger.ONE, BigInteger.TEN}));

        assertArrayEquals(new BigInteger[]{BigInteger.ONE, BigInteger.TEN}, 
                divide(1, new BigInteger[]{BigInteger.TEN, BigInteger.ONE}));

        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(35), BigInteger.valueOf(3)}, 
                divide(5, new BigInteger[]{BigInteger.valueOf(3), BigInteger.valueOf(7)}));
    }

    @Test
    public void testGetConvergentRoot2() {
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(3), BigInteger.valueOf(2)}, 
                ContinuedFraction.getConvergentRootX(2, 1));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(7), BigInteger.valueOf(5)}, 
                ContinuedFraction.getConvergentRootX(2, 2));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(17), BigInteger.valueOf(12)}, 
                ContinuedFraction.getConvergentRootX(2, 3));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(41), BigInteger.valueOf(29)}, 
                ContinuedFraction.getConvergentRootX(2, 4));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(99), BigInteger.valueOf(70)}, 
                ContinuedFraction.getConvergentRootX(2, 5));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(239), BigInteger.valueOf(169)}, 
                ContinuedFraction.getConvergentRootX(2, 6));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(577), BigInteger.valueOf(408)}, 
                ContinuedFraction.getConvergentRootX(2, 7));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(1393), BigInteger.valueOf(985)}, 
                ContinuedFraction.getConvergentRootX(2, 8));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(3363), BigInteger.valueOf(2378)}, 
                ContinuedFraction.getConvergentRootX(2, 9));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(8119), BigInteger.valueOf(5741)}, 
                ContinuedFraction.getConvergentRootX(2, 10));
    }

    @Test
    public void testGetConvergentRoot3() {
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(2), BigInteger.valueOf(1)}, 
                ContinuedFraction.getConvergentRootX(3, 1));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(5), BigInteger.valueOf(3)}, 
                ContinuedFraction.getConvergentRootX(3, 2));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(7), BigInteger.valueOf(4)}, 
                ContinuedFraction.getConvergentRootX(3, 3));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(19), BigInteger.valueOf(11)}, 
                ContinuedFraction.getConvergentRootX(3, 4));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(26), BigInteger.valueOf(15)}, 
                ContinuedFraction.getConvergentRootX(3, 5));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(71), BigInteger.valueOf(41)}, 
                ContinuedFraction.getConvergentRootX(3, 6));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(97), BigInteger.valueOf(56)}, 
                ContinuedFraction.getConvergentRootX(3, 7));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(265), BigInteger.valueOf(153)}, 
                ContinuedFraction.getConvergentRootX(3, 8));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(362), BigInteger.valueOf(209)}, 
                ContinuedFraction.getConvergentRootX(3, 9));
        assertArrayEquals(new BigInteger[]{BigInteger.valueOf(989), BigInteger.valueOf(571)}, 
                ContinuedFraction.getConvergentRootX(3, 10));
    }
}
