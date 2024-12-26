package LeetCode.Hard;

import java.util.Arrays;

public class SplitArrayLargestSum {
    private static boolean canSplit(int arr[], int mid, int k) {
        int subarray = 1;  // Count of subarrays
        int sum = 0;  // Sum of current subarray

        for(int i : arr) {
            if(sum + i > mid) {  // If adding current element exceeds mid, start new subarray
                sum = i;  // Reset sum for new subarray
                subarray++;  // Increment subarray count
            } else {
                sum += i;  // Add element to current subarray
            }

            if(subarray > k) return false;  // Too many subarrays
        }

        return true;  // Subarrays fit within k limit
    }

    public int splitArray(int[] nums, int k) {
        if(k > nums.length) return -1;  // Impossible to split if k > number of elements

        int low = Arrays.stream(nums).max().getAsInt();  // Min value is largest element
        int high = Arrays.stream(nums).sum();  // Max value is sum of all elements

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canSplit(nums, mid, k)) {
                high = mid - 1;  // Try for a smaller subarray sum
            } else {
                low = mid + 1;  // Increase the subarray sum limit
            }
        }

        return low;  // Return the smallest possible largest subarray sum
    }
}
