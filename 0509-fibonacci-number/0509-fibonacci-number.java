//1.using recursion only without dp (slow not store value again and again calculate same recursive function value )
// class Solution {
//     public int fib(int n) {
//         if(n<=1) return n;
//     return fib(n-1)+fib(n-2);
//     }
// }

// // 2.faster
// class Solution {
//     public int fib(int n) {
//         if(n==0) return 0;
//         if(n==1) return 1;

//         int ans1 = fib(n-1);
//         int ans2 = fib(n-2);

//         return ans1+ans2;
//     }
// }


//3. using dp fastest
class Solution {
    public int fib(int n) {
        if(n==0) return 0;  //yeh dono line ke bina bhi run ho sakta hai
        if(n==2 || n==1) return 1;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
/*if we use /int[] dp=new int[n];/ We allocate a size of n + 1 because arrays in Java (and most programming languages) use 0-based indexing.
​Here is how the indexing works for an array created with new int[size]:
​1. Zero-Based Indexing
​When you declare int[] dp = new int[size];, valid index values run from 0 to size - 1.
​If you allocate size n (new int[n]), the valid indices are 0, 1, 2, ..., n - 1.
​Trying to access dp[n] would throw an ArrayIndexOutOfBoundsException because dp[n] does not exist.
​If you allocate size n + 1 (new int[n + 1]), the valid indices are 0, 1, 2, ..., n.
​Now, dp[n] is a valid element at index n.*/