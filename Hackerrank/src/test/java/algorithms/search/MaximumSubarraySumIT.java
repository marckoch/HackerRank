package algorithms.search;

import base.HackerrankFileBasedTest;
import static base.HackerrankFileBasedTest.getAllTestFiles;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import org.junit.Test;
import org.junit.runners.Parameterized;

/**
 *
 * @author marckoch
 */
public class MaximumSubarraySumIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(MaximumSubarraySumIT.class);
        //return getSingleTestFile(MaximumSubarraySumIT.class, "30");
    }

    public MaximumSubarraySumIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws Exception {
        //sor.muteForSuccessfulTests();
        mockStdInFromTestFile(inputFile);

        MaximumSubarraySum.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
