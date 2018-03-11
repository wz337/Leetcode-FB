//Time: O(4^n)
//Space: O(4^n)
//Recursion Tree: Level represents cost. For each level, there are four branches at most. 
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length < 1 || rooms[0].length < 1) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    private void bfs(int[][] rooms, int i, int j) {
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(new Entry(i, j, 0));
        
        while (!queue.isEmpty()) {
            Entry cur = queue.poll();
            for (int[] pair : dir) {
                int r = cur.r + pair[0];
                int c = cur.c + pair[1];
                if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] == 0 || rooms[r][c] == -1) {
                    continue;
                }
                if (rooms[r][c] > cur.cost + 1) {
                    rooms[r][c] = cur.cost + 1;
                    queue.offer(new Entry(r, c, rooms[r][c]));
                }
            }
        }
    }
    
    class Entry {
        int r;
        int c;
        int cost;
        public Entry(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
}
