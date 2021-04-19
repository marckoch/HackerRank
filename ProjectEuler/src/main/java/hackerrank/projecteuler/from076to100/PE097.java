package hackerrank.projecteuler.from076to100;

import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *
 */
public class PE097 {

    public static void solveProjectEuler() {

        // 28433×2^7830457+1
        BigInteger x = BigInteger.TWO.pow(7830457);
        x = x.multiply(BigInteger.valueOf(28433));
        x = x.add(BigInteger.ONE);

        String xStr = x.toString();
        int len = xStr.length();
        System.out.println(xStr.substring(len-10));
    }

    public static void main(String[] args) {
        solveProjectEuler();
        //solveHackerrank();
    }
}
