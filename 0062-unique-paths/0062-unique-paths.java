// // By Recursion
// class Solution {
//     public int uniquePaths(int m, int n) {
//         // Start recursion from the bottom-right corner (m-1, n-1)
//         return countPaths(m - 1, n - 1);
//     }

//     private int countPaths(int i, int j) {
//         // Base Case 1: Reached the top-left origin (0, 0)
//         if (i == 0 && j == 0) {
//             return 1;
//         }

//         // Base Case 2: Out of grid bounds
//         if (i < 0 || j < 0) {
//             return 0;
//         }

//         // Explore moving up and moving left
//         int up = countPaths(i - 1, j);
//         int left = countPaths(i, j - 1);

//         return up + left;
//     }
// }

// // By Memoization
// class Solution {
//     public int uniquePaths(int m, int n) {
//         // Start recursion from the bottom-right corner (m-1, n-1)
//         int dp[][]= new int[m][n];
//         // Best method to fill 2d array
//         // for(int [] row : dp){
//         // Arrays.fill(row,-1)
//         // }

//         //simple method to fill -1 in 2d array
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
//         //         dp[][]=-1;
//         //     }
//         // }

//         // Loop through rows(m), not column (n)
//         for(int i=0; i<m;i++){
//         Arrays.fill(dp[i],-1);//this will fill a complete 1d array row as Arrays.fill(arr,-1)
//         }

//         return countPaths(m - 1, n - 1,dp);
//     }

//     private int countPaths(int i, int j, int dp[][]) {
//         // Base Case 1: Reached the top-left origin (0, 0)
//         if (i == 0 && j == 0) {
//             return 1;
//         }
//         // Base Case 2: Out of grid bounds    
//         if (i < 0 || j < 0) {
//                     return 0;
//         }
//         if (dp[i][j]!=-1) return dp[i][j];
       
//      int up = countPaths(i - 1, j,dp);
//      int left = countPaths(i, j - 1,dp);
//         return dp[i][j] = up + left;
//     }
// }

// By tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp= new int [m][n];
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (i==0&&j==0){ // or dp[0][0]=1; only
                    dp[i][j] = 1;
                    continue;
                }
                int up = (i>0) ? dp[i-1][j] : 0;
                int left =(j>0) ? dp[i][j-1] : 0;
                
                dp[i][j] = up + left;
            }
         }
        return dp[m-1][n-1];
    }
}

// Space Optimization
// import java.util.Arrays;

// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[] prev = new int[n];

//         for (int i = 0; i < m; i++) {
//             int[] temp = new int[n];
//             for (int j = 0; j < n; j++) {
//                 if (i == 0 && j == 0) {
//                     temp[j] = 1;
//                     continue;
//                 }
//                 int up = prev[j];
//                 int left = (j > 0) ? temp[j - 1] : 0;

//                 temp[j] = up + left;
//             }
//             prev = temp;
//         }

//         return prev[n - 1];
//     }
// }