package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class AngryProfessor {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int numberOfTests = in.nextInt();
            for (int i = 0; i < numberOfTests; i++) {
                int students = in.nextInt();
                int cancelThreshold = in.nextInt();
                
                int studentsOnTime = 0;
                for (int j = 0; j < students; j++) {
                    int studentTime = in.nextInt();
                    if (studentTime <= 0) {
                        studentsOnTime++;
                    }
                }
                System.out.println(studentsOnTime >= cancelThreshold ? "NO" : "YES");
            }
        }
    }
}
