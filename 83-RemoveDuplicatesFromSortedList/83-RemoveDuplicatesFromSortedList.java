// Last updated: 9/14/2025, 9:17:28 AM
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null && curr.next!=null){
            if(curr.val == curr.next.val){
                if(head == curr){
                    head = head.next;
                }
                ListNode nextNode = curr.next;
                if(prev!=null){
                    prev.next = nextNode;
                }
                curr = nextNode;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}