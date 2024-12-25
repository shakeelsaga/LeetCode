package LeetCode.Easy;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int missing = n + k;  // Initialize missing value as the end of the range
    
        while(low <= high) {
            int mid = low + (high - low) / 2;  // Find the middle index
    
            if(arr[mid] > k + mid) {  // Check if the mid value exceeds expected number
                missing = k + mid;  // Update missing value
                high = mid - 1;  // Move to the left half
            } else {
                low = mid + 1;  // Move to the right half
            }
        }
    
        return missing;  // Return the missing k-th number
    }
}
