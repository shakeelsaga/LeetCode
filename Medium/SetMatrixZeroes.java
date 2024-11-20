package LeetCode.Medium;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int auxCol = 1; // Tracks if the first column needs to be set to 0.
        
        // Mark rows and columns to be zeroed.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    if(j == 0) {
                        auxCol = 0;
                    } else {
                        matrix[0][j] = 0;
                    }

                    matrix[i][0] = 0;
                }
            }
        }
        
        // Apply zeros to inner matrix.
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                } 
            }
        }

        // Zero out the first row if needed.
        if(matrix[0][0] == 0) {
            for(int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero out the first column if needed.
        if(auxCol == 0) {
            for(int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
