package firsttheme;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PalindromeCheck {

    public static long countOfPalindromes(String strings) {

        return countOfPalindromes(strings.split("\\W+"));
    }

    public static long countOfPalindromes(String[] strings) {

        return Stream.of(strings)
                .filter(s -> !s.isEmpty() && IntStream.range(0, s.length()/2)
                        .allMatch(x -> (s.charAt(x) == s.charAt(s.length() - x - 1))))
                .count();
    }
}
