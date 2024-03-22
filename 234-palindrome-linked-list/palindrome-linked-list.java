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
    public boolean isPalindrome(ListNode head) {
        //first find the point on mid before node
        ListNode tortoise = head;
        ListNode hare = head;
        while(hare.next!=null && hare.next.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        //reverse the another part of link list
        ListNode newHead = reverse(tortoise.next);
        ListNode first = head;
        ListNode second = newHead;
        while(second!=null){
            if(first.val != second.val){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }
    private static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;
    }
}