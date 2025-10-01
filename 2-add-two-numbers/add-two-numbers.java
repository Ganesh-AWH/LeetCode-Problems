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

        int sum = 0;
        int carry = 0;

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while(temp1!=null || temp2!=null){
            int total = carry;

            if(temp1!=null){
                total = total + temp1.val;
                temp1 = temp1.next;
            }
            
            if(temp2!=null){
                total = total + temp2.val;
                temp2 = temp2.next;
            }

            sum = total % 10;
            carry = total/10;

            ListNode newnode = new ListNode(sum);
            temp.next = newnode;
            temp = temp.next;
        }

        if(carry != 0){
            ListNode newnode = new ListNode(carry);
            temp.next = newnode;
        }
        return ans.next;
    }
}




