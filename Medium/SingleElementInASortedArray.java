package LeetCode.Medium;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Edge case: If the array contains only one element
        if(n == 1) return nums[0];
        
        // Check if the single element is at the first or last position
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1, high = n - 2;
        
        // Binary search within the range [1, n-2]
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            // If mid is the non-duplicate element
            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];

            // Determine which half to search based on index parity
            if((mid % 2 == 1 && nums[mid] == nums[mid + 1]) || (mid % 2 == 0 && nums[mid] == nums[mid - 1])) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
