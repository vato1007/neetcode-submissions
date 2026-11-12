
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        boolean[][] visit = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int t = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (visit[r][c]) continue;

            visit[r][c] = true;

            if (r == n - 1 && c == n - 1) {
                return t;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n ||
                    visit[nr][nc]) {
                    continue;
                }

                int newTime = Math.max(t, grid[nr][nc]);

                pq.offer(new int[]{newTime, nr, nc});
            }
        }

        return -1;
    }
}
