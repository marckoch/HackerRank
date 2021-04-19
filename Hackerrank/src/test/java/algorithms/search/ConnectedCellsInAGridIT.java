package algorithms.search;

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
public class ConnectedCellsInAGridIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(ConnectedCellsInAGridIT.class);
        //return getSingleTestFile(ConnectedCellsInAGridIT.class, "30");
    }

    public ConnectedCellsInAGridIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws Exception {
        //sor.muteForSuccessfulTests();
        mockStdInFromTestFile(inputFile);

        ConnectedCellsInAGrid.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
