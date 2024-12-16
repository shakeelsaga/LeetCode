package LeetCode.Medium;

public class FindFirstAndLastOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1, last = -1;
    
        // Find the first occurrence of target
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1; // Continue searching left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    
        // Find the last occurrence of target
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1; // Continue searching right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    
        return new int[]{first, last}; // Return result
    }
}
