package toolbox.root;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author marckoch
 */
public class ContinuedFraction {
    
    public static BigInteger[] expand(int add, BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];

        return new BigInteger[]{bottom.multiply(BigInteger.valueOf(add)).add(top), bottom};
    }

    public static BigInteger[] divide(int n, BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];
        return new BigInteger[]{bottom.multiply(BigInteger.valueOf(n)), top};
    }
    
    public static BigInteger[] simplify(BigInteger[] fraction) {
        BigInteger top = fraction[0];
        BigInteger bottom = fraction[1];
        BigInteger gcd = top.gcd(bottom);
        return new BigInteger[]{top.divide(gcd), bottom.divide(gcd)};
    }

    public static BigInteger[] getConvergentRootX(int x, int iterations) {
        if (x==1) 
            return new BigInteger[] {BigInteger.ONE, BigInteger.ONE};
        
        BigInteger[] current = {BigInteger.valueOf(x-1), BigInteger.valueOf(2)};
        current = simplify(current);
        //System.err.println(" " + Arrays.toString(current));

        for (int i = 1; i<iterations; i++) {
            current = expand(2, current);
            current = divide(x-1, current);
            current = simplify(current);
            //System.err.println(i + " " + Arrays.toString(current));
        }
        current = expand(1, current);
        return current;
    }
    
    public static void main(String[] args) {
        int iterations = 15;
        int x = 2;
        
        for (int i = 1; i <= iterations; i++) {
            System.err.println(String.format("sqrt(%s) in %s iterations = ", x, i) + Arrays.toString(getConvergentRootX(x, i)));
        }
        
        x=3;
        for (int i = 1; i <= iterations; i++) {
            System.err.println(String.format("sqrt(%s) in %s iterations = ", x, i) + Arrays.toString(getConvergentRootX(x, i)));
        }
        
        x=17;
        for (int i = 1; i <= iterations; i++) {
            System.err.println(String.format("sqrt(%s) in %s iterations = ", x, i) + Arrays.toString(getConvergentRootX(x, i)));
        }
        
        x=7;
        for (int i = 1; i <= 300; i++) {
            BigInteger[] t = getConvergentRootX(x, i);
            System.err.println(String.format("sqrt(%s) in %s iterations = ", x, i) + Arrays.toString(t));
            
            
            BigInteger X = t[0];
            BigInteger Y = t[1];
            
            BigInteger left = X.multiply(X);
            BigInteger right = Y.multiply(Y).multiply(BigInteger.valueOf(7)).add(BigInteger.ONE);
            if (left.equals(right)) {
                System.err.println(left + "=" + right);
            }
        }
    }
}
