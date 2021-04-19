
/**
 *
 * @author marckoch
 */
public class Merge {

    // merge two numbers, "append their digits"
    public static long mergeByString(long a, long b) {
        return Long.valueOf(String.valueOf(a) + String.valueOf(b));
    }
    
    // merge two numbers, "append their digits"
    public static long merge(long a, long b) {
        // merge(12, 34) => 1234
        long shift = 10;
        while (shift <= b) {
            shift *= 10;
        }
        return a * shift + b;
    }
    
    public static void main(String[] args) {
        System.out.println(merge(123, 456));
        
        System.out.println(merge(12321, 4));
        
        System.out.println(mergeByString(123, 456));
    }
}
