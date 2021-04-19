package hourrank.no26;

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
public class CloudyDayIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(CloudyDayIT.class);
        //return getSingleTestFile(CloudyDayIT.class, "13");
    }

    public CloudyDayIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws IOException {
        sor.muteForSuccessfulTests();
        mockStdInFromTestFile(inputFile);

        CloudyDay.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
