package algorithms.search;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class ShortPalindromeTest extends HackerrankTest {

    @Test
    public void testSample0() {
        systemInMock.provideLines("kkkkkkz");

        ShortPalindrome.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("15");
    }

    @Test
    public void testSample1() {
        systemInMock.provideLines("ghhggh");

        ShortPalindrome.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("4");
    }

    @Test
    public void testSample2() {
        systemInMock.provideLines("akakak");

        ShortPalindrome.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2");
    }
    
    @Test
    public void testcase6() {
        systemInMock.provideLines("bbbabba");

        ShortPalindrome.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("6");
    }
    
        @Test
    public void testMain1() {
        systemInMock.provideLines("cbcaccbbccacacababcbaaaaccbbabbccacaaacbccbabbbbaacbaabbbbcabcbbcbbbabacccbaacaacaababbaacbbaabacaaaaababaaaabbaabcbcaccbbabcbbbbcbccaaccbabcbccbbccaaaacbcbbccaacaabbbcabcbbcabbcbcbccabcaaaabcababccccbbcbccacb");

        ShortPalindrome.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("8568653");
    }
    
    
}
