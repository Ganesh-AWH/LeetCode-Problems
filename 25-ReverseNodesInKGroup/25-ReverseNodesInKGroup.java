// Last updated: 9/14/2025, 9:18:45 AM
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode nextNode = null;
        while(temp!=null){
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null){
                //find if prev list is found
                //no reverse function for list so prev.next = temp;
                if(prev!=null){
                    prev.next = temp;
                }
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            //already pointers are pointing
            kthNode = reverse(temp);
            //first group
            if(temp == head){
                head = kthNode;
            }else{
                prev.next = kthNode;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
    }
    private static ListNode findKthNode(ListNode head,int k){
        ListNode temp = head;
        for(int i=1;i<k && temp!=null;i++){
            temp = temp.next;
        }
        return temp;
    }
    private static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}