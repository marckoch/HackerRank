package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ACMICPCTeamTest extends HackerrankTest {

    @Test
    public void testMain() {
        systemInMock.provideLines("4 5", "10101", "11100", "11010", "00101");

        ACMICPCTeam.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5", "2");
    }
}
