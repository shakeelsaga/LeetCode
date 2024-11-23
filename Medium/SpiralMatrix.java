package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();  // List to store the elements in spiral order
        int n = matrix.length;  // Number of rows
        int m = matrix[0].length;  // Number of columns

        int top = 0, bottom = n - 1;  // Boundaries for rows
        int left = 0, right = m - 1;  // Boundaries for columns

        // Loop until the boundaries overlap
        while (top <= bottom && left <= right) {
            // Traverse from left to right across the top row
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;  // Move the top boundary down

            // Traverse from top to bottom along the right column
            for (int j = top; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }
            right--;  // Move the right boundary left

            // Traverse from right to left across the bottom row, if applicable
            if (top <= bottom) {
                for (int k = right; k >= left; k--) {
                    list.add(matrix[bottom][k]);
                }
                bottom--;  // Move the bottom boundary up
            }

            // Traverse from bottom to top along the left column, if applicable
            if (left <= right) {
                for (int l = bottom; l >= top; l--) {
                    list.add(matrix[l][left]);
                }
                left++;  // Move the left boundary right
            }
        }

        return list;  // Return the list with elements in spiral order
    }
}
