package firsttheme;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrefixFinder {

    public static String findAPrefix(String[] strings) {
        if(strings.length == 0) {
            return "";
        }
        String[] strs = Stream.of(strings)
                .map(String::toLowerCase)
                .sorted()
                .toArray(String[]::new);
        long count = IntStream.range(0,strs[0].length())
                .takeWhile(i ->  (strs[0].charAt(i) == strs[strs.length-1].charAt(i)))
                .count();
        return strs[0].substring(0,Math.toIntExact(count));
    }
}
