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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null && curr.next!=null){
            //since list is sorted
            if(curr.val == curr.next.val){
                //check if first node itself duplicate
                if(head == curr){
                    head = head.next;
                }
                ListNode nextNode = curr.next;
                if(prev!=null){
                    prev.next = nextNode;
                }
                curr = nextNode;
            }else{
                //only update if there is no duplicate
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}