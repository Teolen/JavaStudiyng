package firsttheme;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketsChecker {

    private static final Pattern pattern = Pattern.compile("[^\\Q(){}[]\\E]");

    public static boolean bracketsValidation(String str) {
        Matcher matcher = pattern.matcher(str);
        char[] charArr = str.toCharArray();

        if (matcher.find()) {
            throw new IllegalArgumentException("String contains not only brackets");
        }
        if(str.isEmpty()) {
            throw new IllegalArgumentException("Empty string");
        }
        if(charArr.length%2 != 0) {
            return false;
        }

        Stack<Character> validator = new Stack<>();

        for(int i = 0; i < charArr.length; i++) {
            switch (charArr[i]) {
                case '(':
                case '{':
                case '[':
                    validator.push(charArr[i]);
                    break;
                case ')':
                    if(validator.empty()) {
                        return false;
                    }
                    if (validator.pop() == '(') {
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if(validator.empty()) {
                        return false;
                    }
                    if(validator.pop() == '{') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if(validator.empty()) {
                        return false;
                    }
                    if(validator.pop() == '[') {
                        break;
                    } else {
                        return false;
                    }
            }
        }
        if(validator.empty()) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        bracketsValidation("");
    }
}
