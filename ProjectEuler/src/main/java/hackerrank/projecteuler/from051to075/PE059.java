package hackerrank.projecteuler.from051to075;

import java.util.Scanner;

/**
 * XOR decryption
 * @author marckoch
 */
public class PE059 {
    private static boolean isValid(char test) {
        if (test >= '0' && test <= '9') return true;
        if (test >= 'a' && test <= 'z') return true;
        if (test >= 'A' && test <= 'Z') return true;
        if (test == '(' || test == ')') return true;
        if (test == ';' || test == ':' || test == ',' || test == '.') return true;
        if (test == '?' || test == '-' || test == ' ' || test == '!' || test == '\'' ) return true;
        return false;
    }
    
    private static boolean isValid(char[] msg) {
        for (char c : msg) {
            if (!isValid(c)) 
                return false;
        }
        return true;
    }

    private static char[] decode(byte[] encoded, char[] password) {
        char[] decodedMsg = new char[encoded.length];
        for (int i=0; i<encoded.length; i++) {
            decodedMsg[i] = (char) (encoded[i] ^ (int) password[i%3]);
        }
        //System.err.println(Arrays.toString(decodedMsg));
        return decodedMsg;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        byte[] text = new byte[N];
        
        for (int i=0; i<N; i++) {
            text[i] = (byte) in.nextInt();
        }
        //System.err.println(Arrays.toString(text));
        //for (int i=0; i<N; i++) {
            //System.err.print((char) text[i]);
        //}
        //System.err.println();
        
        int[] password = new int[]{'a', 'b', 'c'};
        for (int i=0; i<N; i++) {
           System.err.print((char) (text[i] ^ password[i%3]) );
        }
        System.err.println();

        for (char x1='a'; x1<='z'; x1++) {
            for (char x2='a'; x2<='z'; x2++) {
                for (char x3='a'; x3<='z'; x3++) {
                    char[] key = {x1, x2, x3};
                    //System.err.println("trying password " + Arrays.toString(key));
                    char[] decodedMsg = decode(text, key);
                    if (isValid(decodedMsg)) {
                        System.out.println(key);
                        System.err.println(decodedMsg);
                        return;
                    }
                }            
            }            
        }
    }
}
