package base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * TODO convert to JUNit rule ??
 *
 * @author marckoch
 */
//@RunWith(Parameterized.class)
public class HackerrankFileBasedTest extends HackerrankTest {

    protected String inputFile;
    protected String outputFile;

    public HackerrankFileBasedTest(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public static Collection<Object[]> getSingleTestFile(Class myClass, String number) throws IOException, URISyntaxException {
        Path testFileFolder = getTestFileFolder(myClass);
        return getFiles(testFileFolder, "input" + number);
    }

    public static Collection<Object[]> getAllTestFiles(Class myClass) throws IOException, URISyntaxException {
        Path testFileFolder = getTestFileFolder(myClass);
        return getFiles(testFileFolder, "input");
    }
    
    private static Collection<Object[]> getFiles(Path folder, String prefix) throws IOException {
        // get all files whose name starts with 'prefix' and
        // create a List of String[]: {"input99.txt", "output99.txt"}
        return Files.list(folder)
                .filter(Files::isRegularFile)
                .sorted()
                .filter(t -> t.getFileName().toString().startsWith(prefix))
                .map((t) -> {
                    return new String[]{
                        t.getFileName().toString(),
                        t.getFileName().toString().replace("input", "output")};
                })
                .collect(Collectors.toList());
    }

    protected static Path getTestFileFolder(Class myClass) throws URISyntaxException, FileNotFoundException {
        // find folder with test files using classloader
        String fqn = myClass.getName().replace(".", "/") + "/";
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL resource = classloader.getResource(fqn);
        if (resource == null) {
            throw new FileNotFoundException("file not found: " + fqn);
        }
        Path testFileFolder = Paths.get(resource.toURI());
        return testFileFolder;
    }
}
