// Last updated: 9/14/2025, 9:19:23 AM
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int sum = 0;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            int total = carry;
            if(temp1 != null){
                total += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null){
                total += temp2.val;
                temp2 = temp2.next;
            }
            sum = total % 10;
            carry = total / 10;

            curr.next = new ListNode(sum);
            curr = curr.next;
        }

        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}