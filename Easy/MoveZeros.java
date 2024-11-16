package LeetCode.Easy;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;

        // Traverse through the array
        while(i < n && j < n) {
            if(nums[j] != 0) { 
                nums[i] = nums[j];  // Move non-zero elements forward
                i++;
            }
            j++;

            // Fill the rest of the array with zeros
            while(i < n && j == n) {
                nums[i++] = 0;
            }
        }
    }
}
