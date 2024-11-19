package LeetCode.Medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int i = 0;

        while (i <= high) {
            if (nums[i] == 0) {
                // Swap with the low pointer, move low forward
                nums[i] = nums[low];
                nums[low] = 0;
                low++;
            } 
            if (nums[i] == 2) {
                // Swap with the high pointer, move high backward
                nums[i] = nums[high];
                nums[high] = 2;
                high--;
                // Decrement i to re-check the swapped element
                i--;
            }
            i++;
        }

        //Another aproach with O(n) TC
        // int zero = 0, one = 0, two = 0;
        // for(int m = 0; m < nums.length; m++) {
        //     int curr = nums[m];
        //     switch(curr) {
        //         case 0 : zero++; break;
        //         case 1 : one++; break;
        //         case 2 : two++; break;
        //     }
        // }

        // for(int i = 0; i < zero; i++) {
        //     nums[i] = 0;
        // } 
        // for(int j = zero; j < zero + one; j++) {
        //     nums[j] = 1;
        // }
        // for(int k = zero + one; k < zero + one + two; k++) {
        //     nums[k] = 2;
        // }
    }
}
