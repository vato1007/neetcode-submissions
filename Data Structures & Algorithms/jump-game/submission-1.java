public class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }

        return dfs(nums, 0, dp);
    }

    private boolean dfs(int[] nums, int i, int[] dp) {
        if (i >= nums.length - 1) {
            return true;
        }

        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        int end = Math.min(nums.length - 1, i + nums[i]);

        for (int j = i + 1; j <= end; j++) {
            if (dfs(nums, j, dp)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}