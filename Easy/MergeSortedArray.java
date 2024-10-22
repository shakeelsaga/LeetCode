package LeetCode.Easy;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1; // Pointer to the last element of nums1 and nums2
        int x = (m + n) - 1; //full length of nums1

        // Compare elements from the back of both arrays
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[x--] = nums1[i--]; // Place the larger element in the back
            } else {
                nums1[x--] = nums2[j--]; // Place the larger element in the back
            }
        }
        
        // If nums2 has remaining elements, copy them into nums1
        while(j >= 0) {
            nums1[x--] = nums2[j--];
        }
        
        //Another approach
        // int merged[] = new int[m+n];
        // int i = 0;
        // int j = 0;
        // int x = 0;
        // while(i < m && j < n) {
        //     if(nums1[i] <= nums2[j]) {
        //         merged[x++] = nums1[i++];
        //     } else {
        //         merged[x++] = nums2[j++];
        //     }
        // }

        // while(i < m) {
        //     merged[x++] = nums1[i++];
        // }

        // while(j < n) {
        //     merged[x++] = nums2[j++];
        // }

        // for(i = 0, j = 0; i < (m + n); i++, j++) {
        //     nums1[i] = merged[j];
        // }
    }
}