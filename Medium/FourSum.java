package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);  // Sort the array
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicates for 'i'
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  // Skip duplicates for 'j'

                int k = j + 1, l = n - 1;  // Two pointers
                while (k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];  // Calculate sum
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        // Skip duplicates for 'k' and 'l'
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;  // Increase 'k' if sum is less than target
                    } else {
                        l--;  // Decrease 'l' if sum is greater than target
                    }
                }
            }
        }

        return list;  // Return the list of quadruplets
    }
}
