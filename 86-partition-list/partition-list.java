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
    public ListNode partition(ListNode head, int x) {
        //standing/static pointers
        ListNode leftDummy = new ListNode(-1);
        ListNode rightDummy = new ListNode(-1);
        //moving pointers
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        ListNode curr = head;
        while(curr!=null){
            if(curr.val < x){
                left.next = curr;
                left = left.next;
            }else{
                right.next = curr;
                right = right.next;
            }
            curr = curr.next;
        }

        left.next = rightDummy.next;
        right.next = null;
        return leftDummy.next;

    }
}