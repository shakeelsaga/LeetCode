package LeetCode.Medium;

public class RotateImage {
    // Reverse a specific row in the matrix
    private static void revRows(int[][] matrix, int i) {
        int j = 0;
        int j2 = matrix[0].length - 1;
        while (j < j2) {
            // Swap elements at j and j2
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][j2];
            matrix[i][j2] = temp;
            j++;
            j2--;
        }
    }

    // Rotate the matrix 90 degrees clockwise
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix (swap elements across the diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row of the transposed matrix
        for (int i = 0; i < n; i++) {
            revRows(matrix, i);
        }
    }
}
