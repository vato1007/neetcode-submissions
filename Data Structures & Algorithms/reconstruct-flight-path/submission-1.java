
public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adj.get(ticket.get(0)).offer(ticket.get(1));
        }

        List<String> res = new ArrayList<>();

        dfs("JFK", adj, res);

        Collections.reverse(res);

        return res;
    }

    private void dfs(String src,
                     Map<String, PriorityQueue<String>> adj,
                     List<String> res) {

        PriorityQueue<String> pq = adj.get(src);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, adj, res);
        }

        res.add(src);
    }
}
