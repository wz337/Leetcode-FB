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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int[] count = new int[1];
        count[0] = k;
        int[] res = new int[1];
        dfs(root, count, res);
        return res[0];
    }
    private void dfs(TreeNode root, int[] count, int[] res) {
        if (root.left != null) {
            dfs(root.left, count, res);
        }
        count[0]--;
        if (count[0] == 0) {
            res[0] = root.val;
            return;
        }
        if (root.right != null) {
            dfs(root.right, count, res);
        }
    }
}
