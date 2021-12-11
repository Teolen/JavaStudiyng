package firsttheme;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

import static firsttheme.PalindromeCheck.*;

public class PalindromeCheckTest {

    @Test
    public void countOfPalindromesTest() {

        String[] strArr = { "abcv J4f4J . sdfv aaa 9876789",
                            "abba olma quebec 3223 .",
                            "; .'. ;[]; 3223 .",
                            ""};
        List<Long> expected = Arrays.asList(3L,2L,1L,0L);
        List<Long> actual = Stream.of(strArr).
                map(PalindromeCheck::countOfPalindromes).
                collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void countOfPalindromesNullTest() {
        String s = null;
        countOfPalindromes(s);
    }
}