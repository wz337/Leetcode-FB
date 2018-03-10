//Time: O(m * n)
//Space: O(m * n)
//Runtime and space for both DFS and BFS are the same.
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    //dfs(i, j, grid);
                    bfs(i, j, grid);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    // private void dfs(int i, int j, char[][] grid) {
    //     if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
    //         return;
    //     }
    //     int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    //     grid[i][j] = '0';
    //     for (int[] pair : dir) {
    //         dfs(i + pair[0], j + pair[1], grid);
    //     }
    // }
    private void bfs(int i, int j, char[][] grid) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(new Entry(i, j));
        while (!queue.isEmpty()) {
            Entry cur = queue.poll();
            for (int[] pair : dir) {
                int neiI = cur.i + pair[0];
                int neiJ = cur.j + pair[1];
                if (neiI < 0 || neiI >= grid.length || neiJ < 0 || neiJ >= grid[0].length || grid[neiI][neiJ] != '1') {
                    continue;
                }
                grid[neiI][neiJ] = '0';
                queue.offer(new Entry(neiI, neiJ));
            }
        }
    }
    class Entry {
        int i;
        int j;
        public Entry(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
