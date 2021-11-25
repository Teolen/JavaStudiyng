package firsttheme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static firsttheme.SumOfTwo.*;

public class SumOfTwoTest {

    @Test
    public void findASumTest() {

        List<List<Integer>> actual = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();

        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        expected.add(Arrays.asList(0,1));
        int[] nums2 = {3,2,4};
        int target2 = 6;
        expected.add(Arrays.asList(1,2));
        int[] nums3 = {3,3};
        int target3 = 6;
        expected.add(Arrays.asList(0,1));
        int[] nums4 = {5,7};
        int target4 = 6;
        expected.add(Arrays.asList());

        actual.add(findASum(nums1,target1));
        actual.add(findASum(nums2,target2));
        actual.add(findASum(nums3,target3));
        actual.add(findASum(nums4,target4));

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