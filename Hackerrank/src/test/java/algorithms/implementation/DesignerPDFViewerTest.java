package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class DesignerPDFViewerTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5", "abc");

        DesignerPDFViewer.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("9");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 7", "zaba");

        DesignerPDFViewer.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("28");
    }
}
