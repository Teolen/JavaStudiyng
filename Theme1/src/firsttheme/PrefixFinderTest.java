package firsttheme;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static firsttheme.PrefixFinder.*;

import static org.junit.Assert.*;

public class PrefixFinderTest {

    @Test
    public void findAPrefixTest() {
        String[][] testStrings = {{"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"cat", "Caterpillar","catch", "catamaran"},
                {"hyperextension"},
                {}};
        List<String> expected = Arrays.asList("fl","","cat","hyperextension","");
        List<String> actual = Stream.of(testStrings)
                .map(PrefixFinder::findAPrefix)
                .collect(Collectors.toList());
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void findAPrefixNullTest() {
        findAPrefix(null);
    }
}