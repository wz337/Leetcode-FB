/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     } 
    //     ListNode next = head.next;
    //     ListNode newHead = reverseList(next);
    //     next.next = head;
    //     head.next = null;
    //     return newHead;
    // }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
