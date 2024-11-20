package LeetCode.Medium;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) { // Start of a sequence
                int count = 1;
                int ele = num;
                while (set.contains(ele + 1)) { // Count sequence length
                    count++;
                    ele = ele + 1;

                }
                longest = Math.max(longest, count); // Update longest
            }
        }

        return longest;
    }
}
