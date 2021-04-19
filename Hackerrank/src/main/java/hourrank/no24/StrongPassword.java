package hourrank.no24;

import java.util.Scanner;

/**
 *
 * @author marckoch
 */
public class StrongPassword {
    private static final String numbers = "0123456789";
    private static final String lower_case = "abcdefghijklmnopqrstuvwxyz";
    private static final String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String special_characters = "!@#$%^&*()-+";
    
    static int minimumNumber(int n, String password) {
        boolean hasNumber=false;
        boolean hasLowercase=false;
        boolean hasUppercase=false;
        boolean hasSpecialChar=false;
        for (char c : password.toCharArray()) {
            if (numbers.contains(String.valueOf(c))) hasNumber=true;
            else if (lower_case.contains(String.valueOf(c))) hasLowercase=true;
            else if (upper_case.contains(String.valueOf(c))) hasUppercase=true;
            else if (special_characters.contains(String.valueOf(c))) hasSpecialChar=true;
        }
        int missing=0;
        if (!hasNumber) missing++;
        if (!hasLowercase) missing++;
        if (!hasUppercase) missing++;
        if (!hasSpecialChar) missing++;
        if (password.length() + missing < 6) missing=6-password.length();
        return missing;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            String password = in.next();
            int answer = minimumNumber(n, password);
            System.out.println(answer);
        }
    }
}
