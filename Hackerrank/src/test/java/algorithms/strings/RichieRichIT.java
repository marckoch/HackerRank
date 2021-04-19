package algorithms.strings;

import base.HackerrankFileBasedTest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static base.HackerrankFileBasedTest.getAllTestFiles;

/**
 *
 * @author marckoch
 */
@RunWith(Parameterized.class)
public class RichieRichIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(RichieRichIT.class);
    }

    public RichieRichIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws IOException {
        mockStdInFromTestFile(inputFile);

        RichieRich.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
