package LeetCode.Medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                return mid;  // Target found
            }

            // Left half is sorted
            if(nums[mid] >= nums[low]) {
                if(nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;  // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            } 
            // Right half is sorted
            else {
                if(nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1;  // Search left
                }
            }
        }

        return -1;  // Target not found
    }
}
