// // BY RECURSION
// class Solution {
//     public int climbStairs(int n) {
//       if(n==0){
//         return 1;
//       }  
//       if (n<0) return 0;
//       return climbStairs(n-1) + climbStairs(n-2);
//     }
// }

//  BY MEMOISATION
// import java.util.*;
// class Solution {
//     public int climbStairs(int n) {
//       int dp[] = new int[n+1];
//       Arrays.fill(dp, -1);
//       return solve(n, dp);
//     }
//     private int solve(int n, int [] dp){
//       if(n==0){
//         return 1;
//       }  
//       if (n<0) return 0;
//       if (dp[n]!=-1) return dp[n];
//       return dp[n]= solve(n-1,dp) + solve(n-2,dp);
    
//     }
// }

// // by Tabulation 
// import java.util.*;
// class Solution {
//     public int climbStairs(int n) {
//     if (n<=1) return 1;
//     int dp[] = new int[n+1];
//       dp[0] = 1;
//       dp[1] = 1;
//      for (int i=2; i<=n;i++){
//      dp[i]= dp[i-1] + dp[i-2];
//      }
//     return dp[n];
//     }
// }

// by Tabulation 
import java.util.*;
class Solution {
    public int climbStairs(int n) {
    if (n<=1) return 1;
      int prev = 1;// base case at step 0
      int prev2 = 1;// base case at step 1
    for (int i=2; i<=n;i++){
    int curr= prev + prev2;
     prev2 = prev;
     prev = curr;
     }
    return prev;
    }
}