package toolbox.fraction;

/**
 *
 * @author marckoch
 */
public class Farey {

    public static void farey(long n) {
        long count = 0;
        
        // we start with two smallest fractions : 0/1 and 1/n
        long top0 = 0;
        long bottom0 = 1; 
        long top1 = 1; 
        long bottom1 = n;
        
        count++;
        count++;
        System.err.printf("%s/%s\n", top0, bottom0);
        System.err.printf("%s/%s\n", top1, bottom1);
        
        long top2=0, bottom2=0;
        while (bottom2 != 1) {
            int k = (int) ((n + bottom0) / bottom1);
            top2 = k * top1 - top0;
            bottom2 = k * bottom1 - bottom0;
            
            //System.err.printf("%s/%s\n", top2, bottom2);
            count++;
            
            top0 = top1;
            top1 = top2;
            bottom0 = bottom1;
            bottom1 = bottom2;
        }
        System.out.println("**" + count);
    }
    
    public static void main(String[] args) {
        farey(1000);
    }
}
