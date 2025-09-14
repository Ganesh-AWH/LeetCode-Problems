// Last updated: 9/14/2025, 9:16:22 AM
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
    public ListNode sortList(ListNode head) {
        //merge sort
        if(head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }
    public static ListNode merge(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;

        ListNode head;
        if(left.val < right.val){
            head = left;
            left = left.next;
        }else{
            head = right;
            right = right.next;
        }
        head.next = merge(left, right);
        return head;
    }
    public static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}