public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n];

        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

        return Math.min(dfs(cost, 0, memo),
                        dfs(cost, 1, memo));
    }

    private int dfs(int[] cost, int i, int[] memo) {
        if (i >= cost.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(
            dfs(cost, i + 1, memo),
            dfs(cost, i + 2, memo)
        );

        return memo[i];
    }
}