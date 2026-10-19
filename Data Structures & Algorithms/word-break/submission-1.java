public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, wordDict, 0, memo);
    }

    private boolean dfs(String s, List<String> wordDict, int i, Boolean[] memo) {
        if (i == s.length()) {
            return true;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        for (String w : wordDict) {
            if (i + w.length() <= s.length() &&
                s.substring(i, i + w.length()).equals(w)) {

                if (dfs(s, wordDict, i + w.length(), memo)) {
                    memo[i] = true;
                    return true;
                }
            }
        }

        memo[i] = false;
        return false;
    }
}