// Last updated: 9/14/2025, 9:08:34 AM
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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        int sum = 0;
        while(temp2!=null){
            sum += temp2.val;
            if(temp2.val == 0){
                temp1.val = sum;
                temp1 = temp2.next!=null ? temp1.next : temp1;
                sum = 0;
            }
            temp2 = temp2.next;
        }
        temp1.next = null;
        return head;
    }
}