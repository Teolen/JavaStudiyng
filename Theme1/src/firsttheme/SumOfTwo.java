package firsttheme;

import java.util.*;

public class SumOfTwo {

    public static List<Integer> findASum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numsMap = new HashMap<>();

        if(nums.length == 0) {
            throw new IllegalArgumentException("Array is empty.");
        }
        if((nums.length == 1) && nums[0] != target) {
            throw new IllegalArgumentException("Too short nums array.");
        }

        for(int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i++) {
            Integer needed = target - nums[i];
            if((numsMap.containsKey(needed)) && ((numsMap.get(needed) != i))) {
                result.add(i);
                result.add(numsMap.get(needed));
                break;
            }
        }
        return result;
    }
}
