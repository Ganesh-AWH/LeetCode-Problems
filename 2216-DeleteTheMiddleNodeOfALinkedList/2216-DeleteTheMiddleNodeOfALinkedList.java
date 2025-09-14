// Last updated: 9/14/2025, 9:08:47 AM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        ListNode prev = null;
        while(hare != null && hare.next!=null){
            prev = tortoise;
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        if(prev == null || prev.next == null) return null;
        prev.next = tortoise.next;
        tortoise = null;
        return head;
    }
}