package hackerrank.projecteuler.from076to100;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PE096Test {

    int[][] board;

    @Before
    public void setUp() {
        board = new int[][]{
                {0, 0, 3, 0, 2, 0, 6, 0, 0},
                {9, 0, 0, 3, 0, 5, 0, 0, 1},
                {0, 0, 1, 8, 0, 6, 4, 0, 0},
                {0, 0, 8, 1, 0, 2, 9, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 6, 7, 0, 8, 2, 0, 0},
                {0, 0, 2, 6, 0, 9, 5, 0, 0},
                {8, 0, 0, 2, 0, 3, 0, 0, 9},
                {0, 0, 5, 0, 1, 0, 3, 0, 0}
        };
    }

    @Test
    public void extractQuadrant() {
        // top/left
        assertThat(PE096.extractQuadrant(board, 0, 0)).containsExactly(0, 0, 3, 9, 0, 0, 0, 0, 1);

        // middle/middle
        assertThat(PE096.extractQuadrant(board, 3, 3)).containsExactly(1, 0, 2, 0, 0, 0, 7, 0, 8);
        assertThat(PE096.extractQuadrant(board, 4, 4)).containsExactly(1, 0, 2, 0, 0, 0, 7, 0, 8);
        assertThat(PE096.extractQuadrant(board, 4, 5)).containsExactly(1, 0, 2, 0, 0, 0, 7, 0, 8);

        // bottom/right
        assertThat(PE096.extractQuadrant(board, 6, 6)).containsExactly(5, 0, 0, 0, 0, 9, 3, 0, 0);
    }

    @Test
    public void toIntArr() {
        assertThat(PE096.toIntArr("123")).containsExactly(1, 2, 3);
        assertThat(PE096.toIntArr("12321")).containsExactly(1, 2, 3, 2, 1);
    }

    @Test
    public void isValid() {
        assertThat(PE096.isValid(new int[]{0})).isFalse();
        assertThat(PE096.isValid(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0})).isFalse(); // has 0
        assertThat(PE096.isValid(new int[]{1, 1, 1, 1, 5, 6, 7, 8, 0})).isFalse(); // has 1 more than once

        assertThat(PE096.isValid(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})).isTrue(); // has all numbers once
    }

    @Test
    public void testCoordinates() {
        assertThat(board[1][0]).isEqualTo(9);
        assertThat(board[4][0]).isEqualTo(7);
        assertThat(board[0][2]).isEqualTo(3);
    }

    @Test
    public void extractCol() {
        assertThat(PE096.extractCol(board, 0)).containsExactly(0, 9, 0, 0, 7, 0, 0, 8, 0);
        assertThat(PE096.extractCol(board, 1)).containsExactly(0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertThat(PE096.extractCol(board, 2)).containsExactly(3, 0, 1, 8, 0, 6, 2, 0, 5);
        assertThat(PE096.extractCol(board, 3)).containsExactly(0, 3, 8, 1, 0, 7, 6, 2, 0);
    }


}