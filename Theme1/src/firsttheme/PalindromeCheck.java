package firsttheme;

public class PalindromeCheck {

    public static int countOfPalindromes(String strings) {
        return countOfPalindromes(strings.split("\\W+"));
    }

    public static int countOfPalindromes(String[] strings) {
        int result = 0;
        if(strings.length == 0) {
            return result;
        }
        for(String string : strings) {
            if(!string.isEmpty()) {
                if (isPalindrome(string)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length/2; i++) {
            if(chars[i] != chars[chars.length-i-1]) {
                return false;
            }
        }
        return true;
    }
}
