// Last updated: 9/14/2025, 9:15:18 AM
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
    public boolean isPalindrome(ListNode head) 
    {
        Stack<Integer> st= new Stack<>();
        ListNode curr= head;
        while(curr!=null)
        {
            st.push(curr.val);
            curr=curr.next;
        }

        curr=head;
        while (curr!=null)
        {
            if(curr.val!=st.pop())
            {
                return false;
            }
            curr=curr.next;
        }
       return true;
    }
}