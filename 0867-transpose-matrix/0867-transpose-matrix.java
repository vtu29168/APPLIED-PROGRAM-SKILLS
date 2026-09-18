class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Initialize the result matrix with swapped dimensions
        int[][] result = new int[n][m];
        
        // Fill the result matrix
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        
        return result;
        
    }
}