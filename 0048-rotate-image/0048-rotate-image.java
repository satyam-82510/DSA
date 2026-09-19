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
        // Transpose
        for(int i = 0; i<n;i++){
             for(int j = i; j<n;j++){
                int temp = matrix [i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]= temp;
             }
        }
        // reverse
        for(int i = 0; i<n;i++){
        int l =0;
        int r = n-1;
            while(l<r){
                int temp= matrix [i][l];
                matrix[i][l]= matrix [i][r];
                matrix [i][r] = temp;
                l++;
                r--;
            }
        }
    }
}