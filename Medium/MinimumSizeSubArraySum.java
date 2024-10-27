package LeetCode.Medium;

public class MinimumSizeSubArraySum {
    
    public int minSubArrayLen(int target, int[] nums) {
        int minWindowLength = Integer.MAX_VALUE; // Initialize to maximum
        int currSum = 0; // Current sum of the sliding window
        int low = 0; // Start index of the sliding window

        // Iterate through the array with a sliding window approach
        for (int high = 0; high < nums.length; high++) {
            currSum += nums[high]; // Add current element to the sum

            // Check if current sum meets or exceeds the target
            while (currSum >= target) {
                // Calculate the current window size
                int currWindowLength = high - low + 1; // Include the current element

                // Update the minimum window length found so far
                minWindowLength = Math.min(currWindowLength, minWindowLength);

                // Remove the element at the 'low' index and move the window forward
                currSum -= nums[low++];
            }
        }

        // Return the result
        return minWindowLength == Integer.MAX_VALUE ? 0 : minWindowLength;
    }
}
