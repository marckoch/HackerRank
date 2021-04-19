package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ElectronicsShopTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("10 2 3", "3 1", "5 2 8");

        ElectronicsShop.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("9");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("5 1 1", "4", "5");

        ElectronicsShop.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("-1");
    }
}
