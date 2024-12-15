package LeetCode.Hard;

public class ReversePairs {
    private static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];  // Temporary array for merging
    
        int indx1 = si;    // Pointer for the first half
        int indx2 = mid + 1;  // Pointer for the second half
        int x = 0;  // Index for merged array
    
        // Merge two sorted halves
        while (indx1 <= mid && indx2 <= ei) {
            if (arr[indx1] <= arr[indx2]) {
                merged[x++] = arr[indx1++];
            } else {
                merged[x++] = arr[indx2++];
            }
        }
    
        // Add remaining elements from the first half (if any)
        while (indx1 <= mid) {
            merged[x++] = arr[indx1++];
        }
    
        // Add remaining elements from the second half (if any)
        while (indx2 <= ei) {
            merged[x++] = arr[indx2++];
        }
    
        // Copy merged array back to the original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
    
    private static int pairs(int[] arr, int si, int mid, int ei) {
        int count = 0;
        int ssi = mid + 1;
    
        // Count reverse pairs
        for (int i = si; i <= mid; i++) {
            while (ssi <= ei && arr[i] > 2L * arr[ssi]) {
                ssi++;
            }
            count += (ssi - (mid + 1));  // Count valid pairs
        }
        return count;
    }
    
    private static int divide(int arr[], int si, int ei) {
        int count = 0;
        if (si >= ei) {
            return count;  // Base case
        }
        int mid = si + (ei - si) / 2;
    
        // Recursively divide the array and count pairs
        count += divide(arr, si, mid);
        count += divide(arr, mid + 1, ei);
    
        // Count reverse pairs and merge the halves
        count += pairs(arr, si, mid, ei);
        conquer(arr, si, mid, ei);
        return count;
    }
    
    public int reversePairs(int[] nums) {
        return divide(nums, 0, nums.length - 1);  // Initiate divide and conquer
    }
}
