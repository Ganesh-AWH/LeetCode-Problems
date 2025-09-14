// Last updated: 9/14/2025, 9:11:57 AM
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
    public ListNode middleNode(ListNode head) {
        // tortoise and hare approach
        ListNode tortoise = head;
        ListNode hare = head;
        while(hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        //since if hare covers d distance tortoise cover d/2 distance
        return tortoise;
    }
}