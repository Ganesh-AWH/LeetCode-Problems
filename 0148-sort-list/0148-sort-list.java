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
        if(head == null || head.next==null) return head;

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left  = head;
        left = sortList(left);
        right = sortList(right);
        return merge(left,right);
    }
    private static ListNode findMiddle(ListNode head){
        ListNode tortoise = head;
        //it is used to find middle for even number
        ListNode hare = head.next;

        while(hare!=null && hare.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        return tortoise;
    }
    private static ListNode merge(ListNode first,ListNode second){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(first!=null && second!=null){
            if(first.val<=second.val){
                temp.next = first;
                temp = temp.next;
                first = first.next;
            }else{
                temp.next = second;
                temp = temp.next;
                second = second.next;
            }
        }
        if(first!=null){
            temp.next = first;
        }else{
            temp.next = second;
        }
        return dummyNode.next;
    }
}