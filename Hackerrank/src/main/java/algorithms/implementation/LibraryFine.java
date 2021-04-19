package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class LibraryFine {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int actDay = in.nextInt();
            int actMonth = in.nextInt();
            int actYear = in.nextInt();
            
            int expDay = in.nextInt();
            int expMonth = in.nextInt();
            int expYear = in.nextInt();
            
            if (actYear > expYear) {
                System.out.println(10000);
            } else if (actYear == expYear && actMonth > expMonth) {
                System.out.println((actMonth - expMonth) * 500);
            } else if (actYear == expYear && actMonth == expMonth && actDay > expDay) {
                System.out.println((actDay - expDay) * 15);
            } else {
                System.out.println(0);
            }
        }
    }
}
