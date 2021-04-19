package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * TODO convert to JUNit rule ??
 *
 * @author marckoch
 */
public class HackerrankTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final SystemErrRule ser = new SystemErrRule().enableLog();

    long duration;

    @Before
    public void before() {
        duration = System.currentTimeMillis();
    }

    @After
    public void after() {
        //System.err.println(ser.getLog());
        System.err.println("took " + (System.currentTimeMillis() - duration) + " ms");
    }

    protected void assertThatSystemOutEqualsIgnoreWhiteSpace(String... expectedLines) {
        String[] actualLines = sor.getLog().split("\r?\n");

        //Assert.assertArrayEquals(expectedLines, actualLines);
        Assert.assertEquals(expectedLines.length, actualLines.length);
        for (int i = 0; i < expectedLines.length; i++) {
            Assert.assertEquals("error in line " + (i + 1) + ": ", expectedLines[i].trim(), actualLines[i].trim());
        }
    }

    public String[] readStdInFromFileFQN(String fqn) throws IOException {
        List<String> lines = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        URL resource = classloader.getResource(fqn);
        if (resource == null) {
            throw new FileNotFoundException("file not found: " + fqn);
        }

        try (InputStream is = classloader.getResourceAsStream(fqn);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        //System.err.println(lines);
        return lines.toArray(new String[lines.size()]);
    }

    // input file can be downloaded from hackerrank
    // should be placed in src/main/resources/<package>/<Test Classname>/input10.txt
    // e.g. src/main/resources/algorithms/strings/BearAndSteadyGeneTest/input10.txt
    public void mockStdInFromTestFile(String name) throws IOException {
        String fqn = buildFullyQualifiedName(name);
        systemInMock.provideLines(readStdInFromFileFQN(fqn));
    }

    // input file can be downloaded from hackerrank
    // should be placed in src/main/resources/<package>/<Test Classname>/output10.txt
    // e.g. src/main/resources/algorithms/strings/BearAndSteadyGeneTest/output10.txt
    public void assertStdOutAgainstTestFile(String name) throws IOException {
        String fqn = buildFullyQualifiedName(name);
        assertThatSystemOutEqualsIgnoreWhiteSpace(readStdInFromFileFQN(fqn));
    }

    protected String buildFullyQualifiedName(String name) {
        return this.getClass().getName().replace(".", "/") + "/" + name;
    }
}
