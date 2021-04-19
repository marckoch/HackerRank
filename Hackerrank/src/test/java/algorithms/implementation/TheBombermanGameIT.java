package algorithms.implementation;

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
public class TheBombermanGameIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(TheBombermanGameIT.class);
    }
    
    public TheBombermanGameIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }
    
    @Test
    public void testFile() throws IOException {
        mockStdInFromTestFile(inputFile);

        TheBombermanGame.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
