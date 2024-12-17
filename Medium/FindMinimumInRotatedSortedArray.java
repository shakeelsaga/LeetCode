package LeetCode.Medium;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low)/2;  // Find the mid-point
            
            if(nums[mid] > nums[high]) {  // Minimum is in the right half
                low = mid + 1;
            } else {  // Minimum could be at mid or in the left half
                high = mid;
            }
        }

        return nums[low];  // `low` now points to the minimum element
    }
}
