package algorithms.dynamicprogramming;

import base.HackerrankFileBasedTest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import org.junit.Test;
import org.junit.runners.Parameterized;

/**
 *
 * @author marckoch
 */
public class SamAndSubstringsIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(SamAndSubstringsIT.class);
        //return getSingleTestFile(SamAndSubstringsIT.class, "30");
    }

    public SamAndSubstringsIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws Exception {
        //sor.muteForSuccessfulTests();
        mockStdInFromTestFile(inputFile);

        SamAndSubstrings.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
