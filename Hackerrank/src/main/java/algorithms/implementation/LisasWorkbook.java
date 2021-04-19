package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class LisasWorkbook {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int chapters = in.nextInt();
            int probPerPage = in.nextInt();
            int[] probPerChapter = new int[chapters+1];
            for (int i=1; i<=chapters; i++) {
                probPerChapter[i] = in.nextInt();
            }
            
            solve(chapters, probPerChapter, probPerPage);
        }
    }

    static void solve(int chapters, int[] probPerChapter, int probPerPage) {
        int currentPage=1;
        int specialProblem=0;
        for (int c=1; c<=chapters; c++) {
            for (int p=1; p<=probPerChapter[c]; p++) {
                //System.err.println("c=" + c + " p=" + p + " page=" + currentPage);
                if (p==currentPage) {
                    specialProblem++;
                    //System.err.println("  special problem found , now " + specialProblem);
                }
                if (p%probPerPage==0) {
                    currentPage++;
                    //System.err.println("  switching page, now " + currentPage);
                } else if (p==probPerChapter[c]) {
                    currentPage++;
                    //System.err.println("  switching page (no more probs in chapter), now " + currentPage);
                }
            }
        }
        System.out.println(specialProblem);
    }
}
