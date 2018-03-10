/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Time: O(n) n is the number of nodes
//Space: O(nlgk) k is the size of the heap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1,l2) -> Integer.compare(l1.val, l2.val));
        for (ListNode l : lists) {
            if (l != null) {
                pq.offer(l);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
