// Last updated: 9/14/2025, 9:09:29 AM
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode change1 = list2;
        ListNode change2 = list2;
        while(change2.next!=null){
            change2 = change2.next;
        }
        ListNode temp = list1;
        ListNode first = null;
        ListNode second = null;
        for(int i=1;temp!=null;i++){
            if(i==a){
                first = temp;
            }
            if(i==b+1){
                second = temp.next;
                break;
            }
            temp = temp.next;
        }
        
        first.next = change1;
        change2.next = second;
        return list1;
    }
}