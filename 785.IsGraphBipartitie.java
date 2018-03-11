//Time: O(neighbors^nodes)
//Space: O(neighbors^nodes)
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length < 1) {
            return true;
        }
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < graph.length; i++) {
            if (!bfs(i, graph, map)) {
                return false;
            }
        }
        return true;
    }
    private boolean bfs(int i, int[][] graph, Map<Integer, Boolean> map) {
        if (map.containsKey(i)) {
            return true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        map.put(i, true);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            boolean curGroup = map.get(cur);
            boolean neiGroup = !curGroup;
            for (int nei : graph[cur]) {
                if (map.containsKey(nei)) {
                    if (map.get(nei) != neiGroup) {
                        return false;
                    }
                } else {
                    map.put(nei, neiGroup);
                    queue.offer(nei);
                }
            }
        }
        return true;
    }
}

