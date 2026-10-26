class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        if (intervals.length == 0) return 0;

        int removed = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                removed++;
            } else {
                end = intervals[i][1];
            }
        }

        return removed;
    }
}