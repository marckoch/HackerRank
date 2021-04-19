package algorithms.sorting;

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
public class InsertionSortPart2IT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(InsertionSortPart2IT.class);
        //return getSingleTestFile(InsertionSortPart2IT.class, "30");
    }

    public InsertionSortPart2IT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws Exception {
        sor.muteForSuccessfulTests();
        mockStdInFromTestFile(inputFile);

        InsertionSortPart2.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
