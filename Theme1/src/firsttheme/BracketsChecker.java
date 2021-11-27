package firsttheme;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketsChecker {

    private static final Pattern pattern = Pattern.compile("[^\\Q(){}[]\\E]");

    public static boolean bracketsValidation(String str) {
        Matcher matcher = pattern.matcher(str);

        if(str.isEmpty()) {
            throw new IllegalArgumentException("Empty string");
        }
        if (matcher.find()) {
            throw new IllegalArgumentException("String contains not only brackets");
        }

        char[] charArr = str.toCharArray();

        if(charArr.length%2 != 0) {
            return false;
        }

        Stack<Character> validator = new Stack<>();

        for(char ch : charArr) {
            switch (ch) {
                case '(', '{', '[' -> validator.push(ch);
                case ')' -> {
                    if (((validator.empty()) || (validator.pop() != '('))) {
                        return false;
                    }
                }
                case '}' -> {
                    if (((validator.empty()) || (validator.pop() != '{'))) {
                        return false;
                    }
                }
                case ']' -> {
                    if (((validator.empty()) || (validator.pop() != '['))) {
                        return false;
                    }
                }
            }
        }
        return (validator.empty());
    }
}
