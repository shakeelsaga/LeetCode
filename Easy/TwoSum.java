package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();  // To store numbers and their indices

        int i = 0;
        while(i < nums.length) {
            // Check if the complement (target - nums[i]) exists in the map
            if(map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};  // Return indices if found
            }
            map.put(nums[i], i);  // Store the current number and its index in the map
            i++;
        }

        return new int[] {-1};  // Return -1 if no solution is found
    }
}
