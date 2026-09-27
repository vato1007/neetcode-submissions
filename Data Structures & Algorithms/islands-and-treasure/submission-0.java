class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Start BFS from every treasure chest
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                // Out of bounds
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Only visit unvisited land cells
                if (grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}