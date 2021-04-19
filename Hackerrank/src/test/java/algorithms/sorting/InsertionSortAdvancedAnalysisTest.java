package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class InsertionSortAdvancedAnalysisTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "5",
                "1 1 1 2 2",
                "5",
                "2 1 3 1 2");

        InsertionSortAdvancedAnalysis.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0", "4");
    }
}
