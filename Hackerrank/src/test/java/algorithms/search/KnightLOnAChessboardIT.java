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
public class KnightLOnAChessboardIT extends HackerrankFileBasedTest {

    @Parameterized.Parameters(name = "using {0} and {1}")
    public static Collection<Object[]> getTestFiles() throws IOException, URISyntaxException {
        return getAllTestFiles(KnightLOnAChessboardIT.class);
        //return getSingleTestFile(KnightLOnAChessboardIT.class, "30");
    }

    public KnightLOnAChessboardIT(String inputFile, String outputFile) {
        super(inputFile, outputFile);
    }

    @Test
    public void testFile() throws Exception {
        //sor.muteForSuccessfulTests();
        mockStdInFromTestFile(inputFile);

        KnightLOnAChessboard.main(null);

        assertStdOutAgainstTestFile(outputFile);
    }
}
