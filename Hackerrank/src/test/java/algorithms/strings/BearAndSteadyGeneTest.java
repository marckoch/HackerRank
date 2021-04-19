package algorithms.strings;

import base.HackerrankTest;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class BearAndSteadyGeneTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("8", "GAAATAAA");

        BearAndSteadyGene.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("5");
    }

    @Test
    public void testMainInput9() throws IOException {
        mockStdInFromTestFile("input10.txt");

        BearAndSteadyGene.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("55937");
    }
}
