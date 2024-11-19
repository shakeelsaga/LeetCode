package LeetCode.Medium;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;  // Tracks the current subarray sum
        int maxSum = Integer.MIN_VALUE;  // Stores the maximum subarray sum found so far
        
        int i = 0;
        while(i < nums.length) {
            sum += nums[i];  // Add current element to the current subarray sum

            maxSum = Math.max(sum, maxSum);  // Update maxSum if the current subarray sum is larger

            if(sum < 0) {  // Reset the current subarray sum if it goes negative
                sum = 0;
            } 
            i++;
        }

        return maxSum;  // Return the maximum subarray sum found
    }
}
