// 1. Recursion: TC O(2^(m+n)) | SC O(m+n)
// 2. Memoization: TC O(m*n) | SC O(m*n) + O(m+n)
// 3. Tabulation: TC O(m*n) | SC O(m*n)
// 4. Space Optimization: TC O(m*n) | SC O(n)

// // // By Recursion

// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
        
//         return countPaths(m - 1, n - 1, obstacleGrid);
//     }

//     private int countPaths(int i, int j, int[][] obstacleGrid) {
//         // Base Case 1: Out of grid bounds (Must be checked FIRST)
//         if (i < 0 || j < 0) {
//             return 0;
//         }

//         // Base Case 2: Encountered an obstacle
//         if (obstacleGrid[i][j] == 1) {
//             return 0;
//         }

//         // Base Case 3: Reached the top-left origin (0, 0)
//         if (i == 0 && j == 0) {
//             return 1;
//         }

//         // Explore moving up and moving left
//         int up = countPaths(i - 1, j, obstacleGrid);
//         int left = countPaths(i, j - 1, obstacleGrid);

//         return up + left;
//     }
// }

// //Memoization
// import java.util.Arrays;

// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;

//         // Step 1: Initialize DP table with -1
//         int[][] dp = new int[m][n];
//         for (int i = 0; i < m; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         // Step 2: Start recursion from bottom-right corner (m-1, n-1)
//         return countPaths(m - 1, n - 1, obstacleGrid, dp);
//     }

//     private int countPaths(int i, int j, int[][] obstacleGrid, int[][] dp) {
//         // Base Case 1: Out of bounds (must check first)
//         if (i < 0 || j < 0) {
//             return 0;
//         }

//         // Base Case 2: Encountered an obstacle
//         if (obstacleGrid[i][j] == 1) {
//             return 0;
//         }

//         // Base Case 3: Reached starting position (0, 0)
//         if (i == 0 && j == 0) {
//             return 1;
//         }

//         // Check if already computed
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         // Recursive transition: explore UP and LEFT
//         int up = countPaths(i - 1, j, obstacleGrid, dp);
//         int left = countPaths(i, j - 1, obstacleGrid, dp);

//         // Store and return result
//         return dp[i][j] = up + left;
//     }
// }

// // By Tabulation 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Condition 1: If there's an obstacle, 0 paths pass through here
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } 
                // Condition 2: Base Case - Starting position
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } 
                // Condition 3: Transition - Sum paths coming from top and left
                else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

// // SPACE Optimisation
// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;

//         // 1D array to keep track of path counts for the current row
//         int[] prev = new int[n];

//         for (int i = 0; i < m; i++) {
//             int[] temp = new int[n];

//             for (int j = 0; j < n; j++) {

//                 // Case 1: Obstacle encountered
//                 if (obstacleGrid[i][j] == 1) {
//                     temp[j] = 0;
//                 } 
//                 // Case 2: Starting cell (0, 0)
//                 else if (i == 0 && j == 0) {
//                     temp[j] = 1;
//                 } 
//                 // Case 3: Calculate sum of top and left paths
//                 else {
//                     int up = prev[j];                 // Value from the previous row
//                     int left = (j > 0) ? temp[j - 1] : 0; // Value from the left cell in current row

//                     temp[j] = up + left;
//                 }
//             }

//             // Move current row data to prev for the next iteration
//             prev = temp;
//         }

//         return prev[n - 1];
//     }
// }

