package firsttheme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static firsttheme.PalindromeCheck.*;

public class PalindromeCheckTest {

    @Test
    public void countOfPalindromesTest() {

        String[] strArr = { "abcv J4f4J . sdfv aaa 9876789",
                            "abba olma quebec 3223 .",
                            "; .'. ;[]; 3223 .",
                            ""};
        List<Integer> expected = Arrays.asList(3,2,1,0);
        List<Integer> actual = new ArrayList<>();
        for(String str : strArr) {
            actual.add(countOfPalindromes(str));
        }

        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void countOfPalindromesNullTest() {
        String s = null;
        countOfPalindromes(s);
    }
}