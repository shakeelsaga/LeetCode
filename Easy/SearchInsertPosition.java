package LeetCode.Easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;                 //Target is found
            } else if(nums[mid] < target) {
                low = mid + 1;              //move to the right
            } else {
                high = mid - 1;             //Move to the left
            }
        }

        return low; //Position to insert
    }
}
