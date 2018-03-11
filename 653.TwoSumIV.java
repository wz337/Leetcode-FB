/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time: O(n)
//Space: O(h)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    private boolean dfs(TreeNode node, Set<Integer> set, int k) {
        if (node == null) {
            return false;
        }
        int remain = k - node.val;
        if (set.contains(remain)) {
            return true;
        }
        set.add(node.val);
        return dfs(node.left, set, k) || dfs(node.right, set, k);
    }
}
