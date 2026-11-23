class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(coins, 0, amount, dp);
    }

    private int dfs(int[] coins, int i, int a, int[][] dp) {
        if (a == 0) {
            return 1;
        }

        if (i >= coins.length) {
            return 0;
        }

        if (dp[i][a] != -1) {
            return dp[i][a];
        }

        // Skip current coin
        int res = dfs(coins, i + 1, a, dp);

        // Take current coin (unlimited usage)
        if (a >= coins[i]) {
            res += dfs(coins, i, a - coins[i], dp);
        }

        dp[i][a] = res;
        return res;
    }
}