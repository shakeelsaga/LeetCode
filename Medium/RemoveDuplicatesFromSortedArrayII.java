package LeetCode.Medium;

public class RemoveDuplicatesFromSortedArrayII {
    

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int i = 1; //Begin from the second element of the nums
        int k = 1; //Pointer to track the position for the next valid element
        int count = 1; // To count occurrences of each element

        while(i < nums.length) {
            // Check if the current element is the same as the previous one
            if(nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1; // Reset count for new element
            }

            // If count is less than or equal to 2, copy the element to position k
            if(count <= 2) {
                nums[k++] = nums[i];
            }
            i++;
        }

        return k; // k is the new length of the array with allowed duplicates
    }
}
