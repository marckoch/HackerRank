package algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class AppleAndOrange {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int houseLeft = in.nextInt();
            int houseRight = in.nextInt();
            int appleTree = in.nextInt();
            int orangeTree = in.nextInt();
            int numberOfApples = in.nextInt();
            int numberOfOranges = in.nextInt();
            
            solve(numberOfApples, in, appleTree, houseLeft, houseRight, numberOfOranges, orangeTree);
        }
    }

    static void solve(int numberOfApples, final Scanner in, int appleTree, int houseLeft, int houseRight, int numberOfOranges, int orangeTree) {
        int numberOfApplesInHouse = 0;
        int numberOfOrangesInHouse = 0;
        
        int[] apple = new int[numberOfApples];
        for (int i = 0; i < numberOfApples; i++) {
            apple[i] = in.nextInt();
            
            int absPosOfApple = appleTree + apple[i];
            if (absPosOfApple >= houseLeft && absPosOfApple <= houseRight) {
                numberOfApplesInHouse++;
            }
        }
        
        int[] orange = new int[numberOfOranges];
        for (int i = 0; i < numberOfOranges; i++) {
            orange[i] = in.nextInt();
            
            int absPosOfOrange = orangeTree + orange[i];
            if (absPosOfOrange >= houseLeft && absPosOfOrange <= houseRight) {
                numberOfOrangesInHouse++;
            }
        }
        
        System.out.println(numberOfApplesInHouse);
        System.out.println(numberOfOrangesInHouse);
    }
}
