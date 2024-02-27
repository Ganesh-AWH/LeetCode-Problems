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
        Set<Integer> set = new HashSet<>();
        ListNode curr = head;
        ListNode prev = null;
        boolean flag = false;
        while(curr!=null && curr.next!=null){
            if(curr.val == curr.next.val){
                set.add(curr.val);
            }
            if(set.contains(curr.val)){
                if(head == curr){
                    head = head.next;
                }
                ListNode nextNode = curr.next;
                if(prev!=null){
                    prev.next = nextNode;
                }
                curr = nextNode;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        //edge case if last element is duplicate;
        if(prev == null && (curr!=null && set.contains(curr.val))) return null;
        if(curr!=null && set.contains(curr.val)){
            prev.next = null;
        }
        return head;
    }
}