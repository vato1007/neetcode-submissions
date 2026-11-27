public class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int[][] matrix, int r, int c, int[][] dp) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int res = 1;

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < matrix.length &&
                nc >= 0 && nc < matrix[0].length &&
                matrix[nr][nc] > matrix[r][c]) {

                res = Math.max(res, 1 + dfs(matrix, nr, nc, dp));
            }
        }

        dp[r][c] = res;
        return res;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int[][] dp = new int[ROWS][COLS];
        int LIP = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                LIP = Math.max(LIP, dfs(matrix, r, c, dp));
            }
        }

        return LIP;
    }
}