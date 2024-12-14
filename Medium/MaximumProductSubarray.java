package LeetCode.Medium;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE; // Stores the maximum product found
        int prefix = 1; // Product from the left
        int suffix = 1; // Product from the right
    
        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1; // Reset if prefix product hits zero
            if (suffix == 0) suffix = 1; // Reset if suffix product hits zero
    
            prefix *= nums[i]; // Multiply current element from the left
            suffix *= nums[n - i - 1]; // Multiply current element from the right
    
            // Update max product with the maximum of prefix or suffix
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }
    
        return maxProd; // Return the maximum product
    }
}
