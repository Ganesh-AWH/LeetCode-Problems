// Last updated: 9/14/2025, 9:07:59 AM
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
    public ListNode doubleIt(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode temp1 = newHead;
        ListNode temp2 = newHead;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        int sum = 0;
        int carry = 0;
        while(temp1!=null){
            sum = carry + temp1.val + temp2.val;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;

            curr.next = newNode;
            curr = curr.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        
        return reverse(dummyNode.next);
    }
    private static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}