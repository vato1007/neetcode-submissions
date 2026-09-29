class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top and left
        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pacific);
        }

        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pacific);
        }

        // Atlantic: bottom and right
        for (int r = 0; r < m; r++) {
            dfs(heights, r, n - 1, atlantic);
        }

        for (int c = 0; c < n; c++) {
            dfs(heights, m - 1, c, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        // Cells reachable from both oceans
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= heights.length ||
                nc < 0 || nc >= heights[0].length) {
                continue;
            }

            // Reverse flow:
            // neighbor must be >= current
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}