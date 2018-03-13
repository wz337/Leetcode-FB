//It does not have to go from root to leaf. It can be any one node to any other node in the tree.

public class LongestPathInBinaryTree {
    public int getLongestPath(TreeNode root) {
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, max) + 1;
        int right = dfs(root.right, max) + 1;
        max[0] = Math.max(max[0], left + right + 1);
        return Math.max(left, right) + 1;
    }
}
