package LeetCode.Medium;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns
        int low = 0, high = (n * m) - 1; // Binary search bounds
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            int i = mid / m, j = mid % m; // Convert mid to 2D matrix indices
            
            if(matrix[i][j] == target) return true; // Target found
            else if(matrix[i][j] < target) low = mid + 1; // Search right
            else high = mid - 1; // Search left
        }
        
        return false; // Target not found
    }
}
