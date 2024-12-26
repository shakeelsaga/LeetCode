package LeetCode.Hard;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        if(n > m) return findMedianSortedArrays(nums2, nums1);  // Ensure nums1 is the smaller array
    
        int low = 0;
        int high = n;
    
        while(low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = ((n + m + 1) / 2) - mid1;  // Split total elements
    
            // Handle edge cases where partition is at the boundary
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m) ? nums2[mid2] : Integer.MAX_VALUE;
    
            // Check if correct partition
            if(l1 <= r2 && l2 <= r1) {
                if((n + m) % 2 == 0) {  // Even total elements
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {  // Odd total elements
                    return Math.max(l1, l2);
                }
            } else if(l1 > r2) {  // Move left in nums1
                high = mid1 - 1;
            } else {  // Move right in nums1
                low = mid1 + 1;
            }
        }
    
        return 0;
    }
}
