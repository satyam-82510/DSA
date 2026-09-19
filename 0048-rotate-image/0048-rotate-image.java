// brute force but return void error
//  class Solution {
//     public void rotate(int[][] matrix) {
//        int n = matrix.length ;
//        int [][] rotated = new int[n][n];
//        for(int i = 0; i<n;i++){
//              for(int j = 0; j<n;j++){
//                 rotated[j][n-i-1] = matrix[i][j];
//              }
//        } 
//     }
// }

// optimal no new matrix form inself matrix
// tc = O(n/2 * n/2    +  n/2)
// sc = O(1);
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}