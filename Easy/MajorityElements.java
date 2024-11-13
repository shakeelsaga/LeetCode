package LeetCode.Easy;

public class MajorityElements {
    public int majorityElement(int[] nums) {
        int counter = 1;
        int majority = nums[0];
        int i = 1, n = nums.length;
    
        // First pass: Find the majority element candidate
        while(i < n) {
            if(nums[i] == majority) {
                counter++;         // Increment if current matches majority
            } else {
                counter--;         // Decrement if it doesn't
            }
    
            if(counter < 1) {      // Reset majority candidate if counter drops to zero
                majority = nums[i];
                counter = 1;
            }
            i++;
        }
    
        // Second pass: Confirm if the candidate is the majority
        counter = 0;
        for(int j : nums) {
            if(j == majority) {
                counter++;
            }
        }
    
        // Return the majority if it occurs more than n/2 times
        return counter > n/2 ? majority : -1;
    }
}
