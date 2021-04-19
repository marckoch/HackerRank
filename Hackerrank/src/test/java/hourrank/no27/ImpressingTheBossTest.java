package hourrank.no27;

import base.HackerrankTest;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ImpressingTheBossTest extends HackerrankTest {

    @Test
    public void testMain1() throws IOException {
        systemInMock.provideLines("2",
                "8",
                "5 7 7 11 15 12 22 24",
                "9",
                "20 19 18 16 14 15 14 13 11");

        ImpressingTheBoss.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("YES", "NO");
    }

}
