package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int counter = 0;  
        int preSum = 0; 

        // Initialize the map with base case: sum 0 has occurred once
        map.put(0, 1);

        for(int i = 0; i < n; i++) {
            preSum += nums[i];  
            int rem = preSum - k;
            
            // If the remaining sum exists in the map, add its frequency to the counter
            counter += map.getOrDefault(rem, 0);
            
            // Update the map with the current cumulative sum, increasing its count
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        //For Posiive numbers only
        // int n = nums.length;
        // int sum = 0;
        // int counter = 0;

        // int i = 0, j = 0;
        // while(i < n) {
        //     sum += nums[i];

        //     while(sum >= k && j < n) {
        //         if(sum == k) counter++;
        //         sum -= nums[j++];
        //     }
        //     i++;
        // }

        return counter;
    }
}
