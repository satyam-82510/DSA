class Solution {

    static int dp[];

    public int loot(int i, int nums[], int end) {

        if(i > end) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = nums[i] + loot(i+2, nums, end);
        int skip = loot(i+1, nums, end);

        int ans = Math.max(pick, skip);

        return dp[i] = ans;
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1) return nums[0];

        dp = new int[n];
        Arrays.fill(dp, -1);
        int first = loot(0, nums, n-2);

        dp = new int[n];
        Arrays.fill(dp, -1);
        int last = loot(1, nums, n-1);

        return Math.max(first, last);
    }
}