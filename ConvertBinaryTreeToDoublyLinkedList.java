//Link the tree into a doublely linkedlist in inorder fashion
//We are visiting the tree in an inorder fashion. If a prev is null, that means it is the head.
public class ConvertBinaryTreeToDLL {

    TreeNode head = null, prev = null;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return head;
    }

    private void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convert(root.left);
        root.left = prev;
        //we could safely modify a node's left pointer to point to the previously traversed nodes as we
        //will never use it once we reach a node.
        //We could also need to modify the previously traversed node's right pointer to point to the current node.
        //Before that, we need to assign the list's head pointer. And we also need to point the last element back to the head.
        //In order to do that we update the current node's right pointer to head and the head's left pointer to current node.
        //When we reach the end of the tree, the list's head and tail would be connected together.
        //Corner case: a list with only one element will have its left and right pointers both pointing to itself.
        if (prev != null) {
            prev.right = root;
        } else {
            head = root;
        }
        TreeNode right = root.right;
        head.left = root;
        root.right = head;
        prev = root;
        convert(right);
    }

    /*
            4
         2     5
       1  3

     head          prev  cur   next
       1 <-> 2 <-> 3 <-> 4 <-> 5 <->
     */
}
