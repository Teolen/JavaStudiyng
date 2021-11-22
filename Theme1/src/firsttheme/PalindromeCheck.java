package firsttheme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalindromeCheck {
    private static final Pattern pattern = Pattern.compile("\\W");
    private static Matcher matcher;
    public static int countOfPalindromes(String strings) {
        int retval = 0;
        if (strings.equals("")) return retval;
        for(String string : strings.split(" ")) {
            if(isPalindrome(string)) retval++;
        }
        return retval;
    }
    public static int countOfPalindromes(String[] strings) {
        int retval = 0;
        if(strings.length == 0) return retval;
        for(String string : strings) {
            if(isPalindrome(string)) retval++;
        }
        return retval;
    }
    private static boolean isPalindrome(String str) {
        matcher = pattern.matcher(str);
        if (matcher.find()) return false;
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length/2; i++) {
            if(chars[i] != chars[chars.length-i-1]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(countOfPalindromes(args));
        System.out.println(countOfPalindromes("abcv J4f4J . sdfv aaa 9876789"));
    }
}
