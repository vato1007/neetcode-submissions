public class Solution {
    private int dfs(int i, String s, int[] dp) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;

        if (dp[i] != -1) return dp[i];

        int res = dfs(i + 1, s, dp);

        if (i + 1 < s.length()) {
            if (s.charAt(i) == '1' ||
                (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                res += dfs(i + 2, s, dp);
            }
        }

        return dp[i] = res;
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        return dfs(0, s, dp);
    }
}