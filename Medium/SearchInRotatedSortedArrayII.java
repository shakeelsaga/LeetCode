package LeetCode.Medium;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
    
        while(low <= high) {
            int mid = low + (high - low) / 2;
    
            if(nums[mid] == target) return true; // Found target
    
            // Left half is sorted
            if(nums[mid] >= nums[low]) {
                if(nums[low] == nums[mid]) low++; // Handle duplicate
                else if(nums[low] <= target && target < nums[mid]) high = mid - 1; // Search left half
                else low = mid + 1; // Search right half
            } 
            // Right half is sorted
            else {
                if(nums[high] == nums[mid]) high--; // Handle duplicate
                else if(nums[mid] < target && target <= nums[high]) low = mid + 1; // Search right half
                else high = mid - 1; // Search left half
            }
        }
    
        return false; // Target not found
    }
}
