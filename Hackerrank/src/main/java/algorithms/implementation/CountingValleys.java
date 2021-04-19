package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class CountingValleys {
    static int countValleys(int n, String steps) {
        //System.err.println(steps);
        int level=0;
        int countValleys=0;
        boolean valleyEntered=false;
        for (int i=0; i<n; i++) {
            char step = steps.charAt(i);
            if (step=='U') level++;
            if (step=='D') level--;
            
            //System.err.println(level);
            
            if (level== -1) {
                valleyEntered=true;
            } else if (level==0 && valleyEntered==true) {
                countValleys++;
                valleyEntered=false;
            }
        }
        return countValleys;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            in.nextLine();
            String steps = in.nextLine();
            int result = countValleys(n, steps);
            System.out.println(result);
        }
    }
}
