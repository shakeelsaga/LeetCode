package LeetCode.Medium;

public class RearrangeArrayElementsbySign {
    public int[] rearrangeArray(int[] nums) {
        int ans[] = new int[nums.length];

        int i = 0, pIndex = 0, nIndex = 1;
        while(i < nums.length) {
            if(nums[i] > 0) {
                ans[pIndex] = nums[i];  // Place positive at even index
                pIndex += 2;
            } else {
                ans[nIndex] = nums[i];  // Place negative at odd index
                nIndex += 2;
            }
            i++;
        }

        return ans;
    }
}
