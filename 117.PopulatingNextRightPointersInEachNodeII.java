//Time: O(n)
//Space: O(1)
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null; //denote the head of the child level
        TreeLinkNode prev = null; //denote the previous element of the child level
        TreeLinkNode cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            prev = null;
            head = null;
        }
    }
}
