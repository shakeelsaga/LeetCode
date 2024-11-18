package LeetCode.Easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sumOfN = 0;    // Sum of first n natural numbers
        int sumHere = 0;   // Sum of the elements in the array
        
        for(int i = 1; i <= nums.length; i++) {
            sumOfN += i;              // Calculate sum of numbers from 1 to n
            sumHere += nums[i - 1];   // Calculate sum of elements in the array
        }

        return sumOfN - sumHere;   // The difference gives the missing number
     }
}
