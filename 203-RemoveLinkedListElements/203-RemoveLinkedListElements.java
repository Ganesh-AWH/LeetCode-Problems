// Last updated: 9/14/2025, 9:15:45 AM
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val == val){
                ListNode nextNode = curr.next;
                prev.next = nextNode;
                curr = nextNode;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }
}