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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;   
        //move tail to last node
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        k = k%len;
        if(k == 0) return head;
        //point last node to head;
        tail.next = head;
        ListNode nthNode = findNthNode(head,len-k);
        head = nthNode.next;
        nthNode.next = null;

        return head;
    }
    private static ListNode findNthNode(ListNode head,int index){
        ListNode temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }

        return temp;
    }
}