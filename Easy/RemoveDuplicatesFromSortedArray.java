package LeetCode.Easy;

public class RemoveDuplicatesFromSortedArray {
    
    public int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty, return 0 since there are no elements to process
        if (nums.length == 0) return 0;

        int i = 0, j = 1; // 'i' tracks the last unique element, 'j' is the iterator for the array

        // Loop through the array starting from the second element (index 1)
        while (j < nums.length) {
            // If the current element at j is the same as the one at i (duplicate)
            if (nums[i] == nums[j]) {
                j++; // Move 'j' to the next element
            } else {
                nums[++i] = nums[j++]; // Copy the unique element from 'j' to 'i + 1' position
                // Move 'j' to the next element for further comparison
            }
        }

        // Return the count of unique elements, which is 'i' + 1
        return i + 1;
    }
}