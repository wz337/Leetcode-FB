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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root, max);
        return max[0];
    }
    private int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left, max)); //You can not include a node if it gives you negative value
        int right = Math.max(0, dfs(root.right, max));
        max[0] = Math.max(max[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
