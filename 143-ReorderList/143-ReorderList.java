// Last updated: 9/14/2025, 9:16:27 AM
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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        int size = stack.size()/2;
        while(size -- > 0){
            ListNode temp2 = stack.pop();
            ListNode next = temp.next;

            temp.next = temp2;
            temp2.next = next;
            temp = next;
        }

        temp.next = null;


    }
}