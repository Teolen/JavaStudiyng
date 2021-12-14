package firsttheme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

import static firsttheme.SumOfTwo.*;

public class SumOfTwoTest {

    @Test
    public void findASumTest() {

        List<List<Integer>> expected = new ArrayList<>();

        int[][] nums = {
                {2,7,11,15},
                {3,2,4},
                {3,3},
                {5,7}
        };
        int[] targets = {9,6,6,6};

        expected.add(Arrays.asList(0,1));
        expected.add(Arrays.asList(1,2));
        expected.add(Arrays.asList(0,1));
        expected.add(Arrays.asList());

        List<List<Integer>> actual = Stream.of(0,1,2,3).map(i -> findASum(nums[i],targets[i])).toList();

        assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findASumIllegalTest() {
        int[] nums = {1};
        findASum(nums,0);
    }

    @Test(expected = NullPointerException.class)
    public void findASumNullTest() {
        findASum(null,0);
    }
}