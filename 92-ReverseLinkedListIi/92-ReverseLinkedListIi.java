// Last updated: 9/14/2025, 9:17:19 AM
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head ==  null || head.next == null) return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode leftNode = dummyNode;
        ListNode leftPrev  = null;
        for(int i=0;i<left;i++){
            leftPrev = leftNode;
            leftNode = leftNode.next;
        }

        ListNode rightNode = leftPrev.next;
        ListNode rightForward = leftNode.next;
        for(int i=left;i<right;i++){
            ListNode nextNode = rightForward.next;
            rightForward.next = rightNode;
            rightNode = rightForward;
            rightForward = nextNode;
        }
        leftPrev.next = rightNode;
        leftNode.next = rightForward;

        return dummyNode.next;
    }
}