// Last updated: 9/14/2025, 9:17:30 AM
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
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while(curr!=null){
            //keep on checking the duplicates
            if(curr.next!=null && curr.val == curr.next.val){
                int duplicateValue = curr.val;
                while(curr!=null && curr.val == duplicateValue){
                    //skip the duplicate values
                    curr = curr.next;
                }
                prev.next = curr;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}