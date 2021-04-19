package algorithms.strings;

import base.HackerrankFileBasedTest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import org.junit.Test;
import org.junit.runners.Parameterized;
import static base.HackerrankFileBasedTest.getAllTestFiles;

/**
 *
 * @author marckoch
 */
public class AshtonAndStringIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(AshtonAndStringIT.class);
    }

    public AshtonAndStringIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws IOException {
        mockStdInFromTestFile(inputFile);

        AshtonAndString.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
