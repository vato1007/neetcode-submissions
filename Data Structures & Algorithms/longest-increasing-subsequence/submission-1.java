
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(nums, 0, -1, dp);
    }

    private int dfs(int[] nums, int i, int j, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }

        int lis = dfs(nums, i + 1, j, dp);

        if (j == -1 || nums[j] < nums[i]) {
            lis = Math.max(lis, 1 + dfs(nums, i + 1, i, dp));
        }

        return dp[i][j + 1] = lis;
    }
}
