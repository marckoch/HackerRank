package hourrank.no25;

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
public class MaximumPalindromesIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(MaximumPalindromesIT.class);
        //return getSingleTestFile(MaximumPalindromesIT.class, "13");
    }

    public MaximumPalindromesIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws IOException {
        sor.muteForSuccessfulTests();
        mockStdInFromTestFile(inputFile);

        MaximumPalindromes.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
