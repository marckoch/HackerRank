package hackerrank.projecteuler.from101to125;

import hackerrank.projecteuler.from101to125.PE109.Field;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PE109Test {

    @Test
    public void reorderFirstTwo() {
        Field S2 = Field.of(1,2);
        Field S3 = Field.of(1,3);

        Field D3 = Field.of(2,3);
        Field T3 = Field.of(3,3);

        assertThat(PE109.reorderFirstTwo(S3, D3)).containsExactly(S3, D3);
        assertThat(PE109.reorderFirstTwo(D3, S3)).containsExactly(S3, D3);

        assertThat(PE109.reorderFirstTwo(S3, T3)).containsExactly(S3, T3);
        assertThat(PE109.reorderFirstTwo(T3, S3)).containsExactly(S3, T3);

        assertThat(PE109.reorderFirstTwo(D3, T3)).containsExactly(D3, T3);
        assertThat(PE109.reorderFirstTwo(T3, D3)).containsExactly(D3, T3);

        assertThat(PE109.reorderFirstTwo(S2, S3)).containsExactly(S2, S3);
        assertThat(PE109.reorderFirstTwo(S3, S2)).containsExactly(S2, S3);

        assertThat(PE109.reorderFirstTwo(S2, D3)).containsExactly(S2, D3);
        assertThat(PE109.reorderFirstTwo(D3, S2)).containsExactly(S2, D3);

        Field T19 = Field.of(3,19);
        Field T20 = Field.of(3,20);

        assertThat(PE109.reorderFirstTwo(T19, T20)).containsExactly(T19, T20);
        assertThat(PE109.reorderFirstTwo(T20, T19)).containsExactly(T19, T20);

        Field T1 = Field.of(3,1);

        assertThat(PE109.reorderFirstTwo(S2, T1)).containsExactly(S2, T1);
        assertThat(PE109.reorderFirstTwo(T1, S2)).containsExactly(S2, T1);


        assertThat(PE109.reorderFirstTwo(S2, T1)).containsExactly(S2, T1);
        assertThat(PE109.reorderFirstTwo(T1, S2)).containsExactly(S2, T1);
    }
}