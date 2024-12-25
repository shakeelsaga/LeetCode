package LeetCode.Medium;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenAThreshold {
    private static int getSum(int[] nums, int divisor) {
        int sum = 0;
        // Calculate the sum of ceil values for each element divided by the divisor
        for (int i : nums) {
            sum += Math.ceil((double) i / divisor);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt(); // The max element in the array

        // Binary search to find the smallest divisor
        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = getSum(nums, mid);

            // Adjust the bounds based on the sum
            if (sum > threshold) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
