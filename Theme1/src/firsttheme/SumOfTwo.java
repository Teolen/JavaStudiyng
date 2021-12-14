package firsttheme;

import java.util.*;
import java.util.stream.Stream;

public class SumOfTwo {

    public static List<Integer> findASum(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        if(nums.length < 2) {
            throw new IllegalArgumentException("Too short nums array.");
        }

        return Stream.iterate(0, i -> i < nums.length, i -> i+1)
                .flatMap(i ->{
                    Integer needed = target - nums[i];
                    if((numsMap.containsKey(needed)))  {
                        return Stream.of(numsMap.get(needed),i);
                    }
                    else {
                        numsMap.put(nums[i],i);
                        return Stream.empty();
                    }
                }).limit(2).toList();
    }
}
