// Last updated: 9/14/2025, 9:18:58 AM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode temp = head;   

        for(int i=0;i<n;i++) temp = temp.next;
        if(temp == null) return head.next;
        ListNode fast = temp;
        ListNode slow = head;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode delNode = slow;
        slow.next = slow.next.next;
        return head;
    }
}