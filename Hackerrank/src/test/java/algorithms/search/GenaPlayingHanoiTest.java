package algorithms.search;

import base.HackerrankTest;
import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class GenaPlayingHanoiTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("3", "1 4 1");

        GenaPlayingHanoi.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3");
    }

    @Test
    public void testHash() {
        System.err.println(GenaPlayingHanoi.stateOfHanoiHash(new int[]{1, 2, 3}));
        System.err.println(GenaPlayingHanoi.stateOfHanoiHash(new int[]{1, 1, 1}));
        System.err.println(GenaPlayingHanoi.stateOfHanoiHash(new int[]{3, 2, 1}));

        System.err.println(GenaPlayingHanoi.stateOfHanoiHash(new int[]{1, 3, 1}));
        System.err.println(GenaPlayingHanoi.stateOfHanoiHash(new int[]{1, 4, 1}));

        System.err.println(GenaPlayingHanoi.stateOfHanoiHash(new int[]{0, 3, 0}));

        int x = GenaPlayingHanoi.stateOfHanoiHash(new int[]{0, 3, 0});
        int n = 3;

        int[] topmostDiscs = new int[4];
        // Integer.MAX_VALUE denotes an empty rod here, i.e. disc of any size can be placed on it
        Arrays.fill(topmostDiscs, Integer.MAX_VALUE);
        // go through the entire array to make sure the smallest discs are picked up
        for (int i = n - 1; i >= 0; i--) {
            int rod = (x >> i * 2) & 0b11;
            topmostDiscs[rod] = i;
            System.err.println(Arrays.toString(topmostDiscs));
        }
        System.err.println(Arrays.toString(topmostDiscs));
        
    }
}
