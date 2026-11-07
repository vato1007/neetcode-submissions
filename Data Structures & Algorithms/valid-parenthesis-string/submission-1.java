public class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return dfs(0, 0, s, dp);
    }

    private boolean dfs(int i, int open, String s, int[][] dp) {
        if (open < 0) return false;
        if (i == s.length()) return open == 0;

        if (dp[i][open] != -1) {
            return dp[i][open] == 1;
        }

        boolean ans;

        if (s.charAt(i) == '(') {
            ans = dfs(i + 1, open + 1, s, dp);
        } else if (s.charAt(i) == ')') {
            ans = dfs(i + 1, open - 1, s, dp);
        } else {
            ans = dfs(i + 1, open, s, dp) ||
                  dfs(i + 1, open + 1, s, dp) ||
                  dfs(i + 1, open - 1, s, dp);
        }

        dp[i][open] = ans ? 1 : 0;
        return ans;
    }
}