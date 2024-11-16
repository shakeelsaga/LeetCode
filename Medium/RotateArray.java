package LeetCode.Medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;  // Adjust k in case it is larger than the array length
    
        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            // Swap elements
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
