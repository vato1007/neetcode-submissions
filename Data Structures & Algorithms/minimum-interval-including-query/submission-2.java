
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        java.util.Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;
        int m = queries.length;
        int[] res = new int[m];
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        java.util.Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        java.util.PriorityQueue<int[]> pq =
            new java.util.PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;

        for (int[] query : sortedQueries) {
            int q = query[0];
            int idx = query[1];

            while (i < n && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.offer(new int[]{r - l + 1, r});
                i++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            res[idx] = pq.isEmpty() ? -1 : pq.peek()[0];
        }

        return res;
    }
}
