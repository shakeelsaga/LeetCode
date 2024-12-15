package LeetCode.Easy;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
    
        // Binary search loop
        while(low <= high) {
            int mid = low + (high - low) / 2;  // Calculate mid index
            
            // If target is found at mid
            if(nums[mid] == target) {
                return mid;
            } 
            // If target is greater, search right half
            else if(nums[mid] < target) {
                low = mid + 1;
            } 
            // If target is smaller, search left half
            else {
                high = mid - 1;
            }
        }
        
        // Return -1 if target is not found
        return -1;
    }
}
