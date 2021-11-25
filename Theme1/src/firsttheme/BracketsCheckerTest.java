package firsttheme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static firsttheme.BracketsChecker.*;

public class BracketsCheckerTest {

    @Test
    public void bracketsValidationTest() {
        List<Boolean> expected = Arrays.asList(true, true, false, false, true);
        List<Boolean> actual = new ArrayList<>();
        actual.add(bracketsValidation("()"));
        actual.add(bracketsValidation("()[]{}"));
        actual.add(bracketsValidation("(]"));
        actual.add(bracketsValidation("([)]"));
        actual.add(bracketsValidation("{[]}"));

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bracketsValidationIllegalTest() {
        bracketsValidation("Hello Validator!");
    }

    @Test(expected = NullPointerException.class)
    public void bracketsValidationNullTest() {
        bracketsValidation(null);
    }
}