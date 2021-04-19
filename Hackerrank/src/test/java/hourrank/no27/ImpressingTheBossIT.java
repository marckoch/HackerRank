package hourrank.no27;

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
public class ImpressingTheBossIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(ImpressingTheBossIT.class);
        //return getSingleTestFile(ImpressingTheBossIT.class, "13");
    }

    public ImpressingTheBossIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws IOException {
        sor.muteForSuccessfulTests();
        mockStdInFromTestFile(inputFile);

        ImpressingTheBoss.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
