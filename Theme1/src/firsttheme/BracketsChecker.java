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
        if(str.length()%2 !=0) {
            return false;
        }

        Stack<Integer> validator = new Stack<>();

        return str.chars().allMatch(c -> switch(c) {
            case '(', '{', '[' -> validator.push(c) != 0;
            case ')' -> (!validator.empty() && validator.pop() == '(');
            case '}' -> (!validator.empty() && validator.pop() == '{');
            case ']' -> (!validator.empty() && validator.pop() == '[');
            default -> false;
        }) && validator.empty();
    }
}
