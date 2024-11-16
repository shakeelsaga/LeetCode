package LeetCode.Easy;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int breakpoint = 1;  // Allow up to 1 breakpoint

        int i = 0, n = nums.length;
        while(i < nums.length) {
            // Check if current element is greater than the next (with wrap-around)
            if(nums[i] > nums[(i + 1) % n]) {
                breakpoint--;  // Decrement if a breakpoint is found
            }

            // If more than 1 breakpoint, array cannot be sorted by rotation
            if(breakpoint < 0) {
                return false;
            }
            i++;
        }

        return true;  // Return true if there is at most 1 breakpoint
    }
}
