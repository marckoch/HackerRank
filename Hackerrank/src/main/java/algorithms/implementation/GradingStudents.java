package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class GradingStudents {

    static int[] solve(int[] grades) {
        // Complete this function
        int[] result = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            result[i] = round(grades[i]);
        }
        return result;
    }

    static int round(int grade) {
        int nextMult = findNextMultipleOfFive(grade);
        if (nextMult < 40) {
            return grade;
        }
        if (nextMult - grade < 3) {
            return nextMult;
        }
        return grade;
    }

    static int findNextMultipleOfFive(int grade) {
        int newGrade = grade;
        while (newGrade % 5 != 0) {
            newGrade++;
        }
        //System.err.println("grade " + grade + " rounded to " + newGrade);
        return newGrade;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            
            int[] grades = new int[n];
            for (int i = 0; i < n; i++) {
                grades[i] = in.nextInt();
            }
            
            int[] result = solve(grades);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
            }
            System.out.println("");
        }
    }
}
