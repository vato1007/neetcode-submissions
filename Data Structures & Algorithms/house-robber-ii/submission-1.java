public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for (int i = 0; i < n; i++) {
            dp1[i] = -1;
            dp2[i] = -1;
        }

        return Math.max(
            dfs(nums, 0, n - 2, dp1),
            dfs(nums, 1, n - 1, dp2)
        );
    }

    private int dfs(int[] nums, int i, int end, int[] dp) {
        if (i > end) return 0;

        if (dp[i] != -1) return dp[i];

        int skip = dfs(nums, i + 1, end, dp);
        int rob = nums[i] + dfs(nums, i + 2, end, dp);

        dp[i] = Math.max(skip, rob);
        return dp[i];
    }
}