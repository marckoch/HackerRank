package hackerrank.projecteuler.from176to200;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Iterative Circle Packing
 *
 * @author marckoch
 */
public class PE199 {

    public static int countCircles = 0;

    public static double area(double radius) {
        return radius * radius * Math.PI;
    }

    public static double[] getK(double k1, double k2, double k3) {
        // k = k1+k2+k3 ± 2 * sqrt(k1*k2 + k2*k3 + k3*k1)
        double[] k = new double[]{k1 + k2 + k3, k1 + k2 + k3};
        double root = Math.sqrt(k1 * k2 + k2 * k3 + k3 * k1);
        k[0] += 2 * root;
        k[1] -= 2 * root;
        //System.err.printf("getK(%s %s %s)=%s\n", k2, k2, k3, Arrays.toString(k));
        //System.err.printf("   radius=[%s, %s]\n", radius(k[0]), radius(k[1]));
        return k;
    }

    public static double getArea(double k1, double k2, double k3, int level, boolean outer, int numberOfInitialCircles) {
        // k4[1] would describe the outer circle which we already have considered in an previous step
        double k4 = getK(k1, k2, k3)[0];

        double area = area(1 / k4);

        if (outer) {
            countCircles += numberOfInitialCircles; // TODO change for hackerrank to  += N
        } else {
            countCircles++;
        }

        //System.err.println(" circle with radius " + radius(k4));
        //System.err.printf("level %s area=%s\n", level, area);
        if (level == 1) {
            return area;
        }

        // this will be three sub tasks, because insertion of
        // new forth circle between creates three new spaces
        return area
                + getArea(k1, k2, k4, level - 1, outer, numberOfInitialCircles)
                + getArea(k2, k3, k4, level - 1, outer, numberOfInitialCircles)
                + getArea(k3, k1, k4, level - 1, outer, numberOfInitialCircles);
    }

    public static double solveProjectEuler(int level) {
        countCircles=0;
        
        // TODO change for hackerrank
        int numberOfInnerCircles = 3;

        // three circles have radius 1
        // TODO change for hackerrank ??
        double radiusInnerCircle = 1.0;
        double kInnerCircle = 1 / radiusInnerCircle;

        // TODO change for hackerrank ??
        double kBigCircle = 3 - 2 * Math.sqrt(3); // is negative!
        double radiusBigCircle = -1 / kBigCircle;
        //System.err.println("radiusBigCircle=" + radiusBigCircle);

        double areaInnerCircles = numberOfInnerCircles * area(radiusInnerCircle);
        countCircles += numberOfInnerCircles;
        //System.err.println("area3Circles=" + area3Circles);

        // outer v shaped areas
        double vShapedOuter = getArea(kBigCircle, kInnerCircle, kInnerCircle, level, true, 3);
        //System.err.println("vShapedOuter=" + vShapedOuter);

        // inner area
        double inner = getArea(kInnerCircle, kInnerCircle, kInnerCircle, level, false, 3);
        //System.err.println("inner=" + inner);

        double totalArea = areaInnerCircles + numberOfInnerCircles * vShapedOuter + inner;
        //System.err.println("totalArea=" + totalArea);
        //System.err.println("areaBigCircle=" + area(radiusBigCircle));

        double ratioCoveredArea = totalArea / area(radiusBigCircle);
        //System.err.println("ratio covered area = " + ratioCoveredArea);

        double ratioFreeArea = 1 - ratioCoveredArea;
        //System.err.println("ratio free = " + ratioFreeArea);
        //System.err.println("circle count=" + countCircles);

        BigDecimal bd = new BigDecimal(ratioFreeArea);
        bd = bd.setScale(8, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double getRadiusBigCircle(int numberOfCircles) {
        double angleInDegree = 180.0d / numberOfCircles;
        //System.err.println("angleInDegree=" + angleInDegree);
        double angleInRad = Math.toRadians(angleInDegree);
        //System.err.println("angleInRad=" + angleInRad);

        double radiusBigCircle = 1 + 1 / Math.sin(angleInRad);
        //System.err.println("radiusBigCircle=" + radiusBigCircle);
        return radiusBigCircle;
    }

    public static void solveHackerrank() {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int M = in.nextInt();
        System.out.println(solveHackerrankInternal(N, M));
    }
    
    public static double solveHackerrankInternal(int numberOfInitialCircles, int level) {
        // very ugly!!
        countCircles=0;
        
        // n initial circles each have radius 1
        double radiusInitialCircle = 1.0;
        double kInitialCircle = 1 / radiusInitialCircle;

        // n circles are surrounded by this big circle
        double radiusBigCircle = getRadiusBigCircle(numberOfInitialCircles);
        double kBigCircle = -1 / radiusBigCircle; // negative because it is a surrounding circle!
        //System.err.println("radiusBigCircle=" + radiusBigCircle);

        double areaInitialCircles = numberOfInitialCircles * area(radiusInitialCircle);
        countCircles += numberOfInitialCircles;
        //System.err.println("areaInitialCircles=" + areaInitialCircles);

        // outer v shaped areas
        double vShapedOuter = getArea(kBigCircle, kInitialCircle, kInitialCircle, level, true, numberOfInitialCircles);
        //System.err.println("vShapedOuter=" + vShapedOuter);

        // inner area
        // first inner middle circle has to be calculated from hand,
        // it can NOT be calculated with DeCartes for more than 3 circles!
        double radiusMiddleCircle = radiusBigCircle - 2 * radiusInitialCircle;
        //System.err.println("radiusMiddleCircle=" + radiusMiddleCircle);
        double areaMiddleCircle = area(radiusMiddleCircle);
        //System.err.println("areaMiddleCircle=" + areaMiddleCircle);
        double kMiddleCircle = 1 / radiusMiddleCircle;
        double inner = areaMiddleCircle;
        countCircles++;
        if (level > 1) {
            inner += numberOfInitialCircles * getArea(kMiddleCircle, kInitialCircle, kInitialCircle, level - 1, false, numberOfInitialCircles);
        }
        //System.err.println("inner=" + inner);

        double totalArea = areaInitialCircles + numberOfInitialCircles * vShapedOuter + inner;
        //System.err.println("totalArea=" + totalArea);
        //System.err.println("areaBigCircle=" + area(radiusBigCircle));

        double ratioCoveredArea = totalArea / area(radiusBigCircle);
        //System.err.println("ratio covered area = " + ratioCoveredArea);

        double ratioFreeArea = 1 - ratioCoveredArea;
        //System.err.println("ratio free = " + ratioFreeArea);
        //System.err.println("circle count=" + countCircles);

        BigDecimal bd = new BigDecimal(ratioFreeArea);
        bd = bd.setScale(12, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void main(String[] args) {
        //System.out.println(solveHackerrankInternal(3, 10));
        //System.out.println(solveHackerrankInternal(4, 1));
        
        //for (int i = 1; i <= 20; i++) {
        //    System.out.println("3 " + i + " " + solveHackerrankInternal(3, i));
        //}
        
        System.out.println(solveHackerrankInternal(100, 1));
        //solveHackerrank();
    }
}
