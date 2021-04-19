package hourrank.no26;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class CloudyDayTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("2",
                "10 100",
                "5 100",
                "1",
                "4",
                "1");

        CloudyDay.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("110");
    }
}
