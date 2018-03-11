/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Recursive:
//Time: O(n)
//Space: O(h)
//Iterative:
//Time: O(n)
//Space: O(1)
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        if (root.val <= p.val) {    //So it won't be p's successor for sure.
            return inorderSuccessor(root.right, p);
        } else {
            //Root might still be p's successor. We need to compare.
            TreeNode temp = inorderSuccessor(root.left, p);
            return temp == null ? root : temp;
        }
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                result = root;
                root = root.left;
            }
        }
        return result;
    }
}

