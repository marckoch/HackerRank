package hackerrank.projecteuler.from051to075;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PE068Test {

    @Test
    public void remove() {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        int[] remaining = PE068.remove(numbers, new int[]{2, 3});
        Assertions.assertThat(remaining).containsExactly(1, 4, 5, 6);
    }
}