package hackerrank.projecteuler.from076to100;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class PE085Test {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Test
    public void solveProjectEuler() {
        systemInMock.provideLines("1", "2000000");

        PE085.solveHackerrank();

        assertThat(sor.getLog(), is("2772\n"));
    }

    @Test
    public void solveHackerrank() {
        systemInMock.provideLines("6", "1", "2", "3", "4", "5", "6");

        PE085.solveHackerrank();

        assertThat(sor.getLog(), is("1\n2\n2\n2\n3\n3\n"));
    }

    @Test
    public void solveHackerrank2() {
        systemInMock.provideLines("8", "18", "2", "33", "1000000", "1999000", "2000000", "100", "276");

        PE085.solveHackerrank();

        assertThat(sor.getLog(), is("6\n2\n9\n1632\n1999\n2772\n16\n23\n"));
    }
}