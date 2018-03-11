/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,"); //Remember the ",". Otherwise, when we split it, there is going to be a problem.
            return;
        }
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(data.split(",")));
        System.out.println(queue);
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#")) {  //Remember that when you compare object and string, you cannot 
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
