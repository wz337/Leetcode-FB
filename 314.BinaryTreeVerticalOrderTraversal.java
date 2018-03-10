/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    class Entry {
        TreeNode node;
        int col;
        public Entry(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(new Entry(root, 0));
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        while (!queue.isEmpty()) {
            Entry curEntry = queue.poll();
            int col = curEntry.col;
            TreeNode cur = curEntry.node;
            
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(cur.val);
            
            if (cur.left != null) {
                queue.offer(new Entry(cur.left, col - 1));
                min = Math.min(col - 1, min);
            }
            
            if (cur.right != null) {
                queue.offer(new Entry(cur.right, col + 1));
                max = Math.max(col + 1, max);
            }
        }
        
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
