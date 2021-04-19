package algorithms.implementation;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class MatrixLayerRotationTest extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("4 4 1",
                "1 2 3 4",
                "5 6 7 8",
                "9 10 11 12",
                "13 14 15 16");

        MatrixLayerRotation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2 3 4 8",
                "1 7 11 12",
                "5 6 10 16",
                "9 13 14 15");
    }

    @Test
    public void testMain2() {
        systemInMock.provideLines("4 4 2",
                "1 2 3 4",
                "5 6 7 8",
                "9 10 11 12",
                "13 14 15 16");

        MatrixLayerRotation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("3 4 8 12",
                "2 11 10 16",
                "1 7 6 15",
                "5 9 13 14");
    }

    @Test
    public void testMain3() {
        systemInMock.provideLines("5 4 7",
                "1 2 3 4",
                "7 8 9 10",
                "13 14 15 16",
                "19 20 21 22",
                "25 26 27 28");

        MatrixLayerRotation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("28 27 26 25",
                "22 9 15 19",
                "16 8 21 13",
                "10 14 20 7",
                "4 3 2 1");
    }

    @Test
    public void testMain4() {
        systemInMock.provideLines("2 2 3",
                "1 1",
                "1 1");

        MatrixLayerRotation.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 1",
                "1 1");
    }
}
