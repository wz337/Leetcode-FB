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
//Space: O(h) h represents the deepest path in our tree.
//Note that if we use String instead of StringBuilder, space complexity would be O(leafnodes * h)
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, result, sb);
        return result;
    }
    private void dfs(TreeNode root, List<String> result, StringBuilder sb) {
        int end = sb.length(); //record the previous end so we can back track
        if (root.left == null && root.right == null) {  //when we hit a leaf node
            sb.append(root.val);
            result.add(sb.toString());
            sb.delete(end, sb.length());
            return;
        }
        sb.append(root.val + "->");
        if (root.left != null) {
            dfs(root.left, result, sb);
        }
        if (root.right != null) {
            dfs(root.right, result, sb);
        }
        sb.delete(end, sb.length());
    }
}
/*
Difference between having leaf nodes and null nodes as base cases:
1. In this question, our base case have to be leaf nodes. Otherwise, one valid path will be printed twice (root.left == null && root.right == null).
2. When we are having leaf nodes as our base case, we need to be careful when we traverse. We have to check whether the left child and right child are null before doing dfs. Otherwise, we will be getting null pointer exception.
3. Rule of thumb: When we are printing the path or getting path sum, use leaf nodes as our base case.
*/
