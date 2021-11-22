package firsttheme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> actual = new ArrayList<>();
        for(String[] strArr : testStrings)
            actual.add(findAPrefix(strArr));
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void findAPrefixNullTest() {
        findAPrefix(null);
    }
}