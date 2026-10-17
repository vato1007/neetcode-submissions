public class Solution {
    public int dfs(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        if (dp[amount] != -1) return dp[amount];

        int res = (int) 1e9;

        for (int coin : coins) {
            if (amount - coin >= 0) {
                res = Math.min(res,
                    1 + dfs(coins, amount - coin, dp));
            }
        }

        return dp[amount] = res;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, -1);

        int minCoins = dfs(coins, amount, dp);

        return (minCoins >= 1e9) ? -1 : minCoins;
    }
}