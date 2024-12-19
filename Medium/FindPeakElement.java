package LeetCode.Medium;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // Edge case: Single element in the array
        if(n == 1) return 0;

        // Check if the first or last element is a peak
        if(nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;
        
        // Binary search within the range [1, n-2]
        while(low <= high) {
            int mid = low + (high - low)/2;

            // If mid is greater than its neighbors, it's a peak
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Move right if mid is increasing
            if(nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                // Otherwise, move left
                high = mid - 1;
            }
        }

        return -1;
    }
}
