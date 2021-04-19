package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class FraudulentActivityNotificationsTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("9 5",
                "2 3 4 2 3 6 8 4 5");

        FraudulentActivityNotifications.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5 4",
                "1 2 3 4 4");

        FraudulentActivityNotifications.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("0");
    }
}
