package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class ChocolateFeast {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();
            while(T-- > 0){
                int dollars = in.nextInt();
                int price = in.nextInt();
                int wrappersExRate = in.nextInt();
                
                solve(dollars, price, wrappersExRate);
            }
        }
    }

    static void solve(int dollars, int price, int wrappersExRate) {
        // convert dollars to chocolate
        int totalChocolate = dollars / price;
        int noWrappers = totalChocolate;
        
        do {
            // convert wrappers to chocolate
            int pieces = noWrappers / wrappersExRate;
            noWrappers -= pieces * wrappersExRate;
            //System.err.println("wrapper -> choc at "+wrappersExRate+" to 1 : pieces="+pieces+" noWrappers=" + noWrappers);
            
            totalChocolate+=pieces;
            //System.err.println("totalChocolate=" + totalChocolate);
            
            // convert chocolate to wrappers
            noWrappers += pieces;
            //System.err.println("choc -> wrapper at 1 to 1 : noWrappers=" + noWrappers);
        } while (noWrappers >= wrappersExRate);
        
        System.out.println(totalChocolate);
    }
}
