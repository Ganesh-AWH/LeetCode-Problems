// Last updated: 9/14/2025, 9:10:27 AM
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
    public int getDecimalValue(ListNode head) {
        int num[] = new int[31];
        int x=0;
        while(head!=null){
            num[x++]=head.val;
            head=head.next;
        }
        int p=0,res=0;
        for(int i=x-1;i>=0;i--){
            res+=num[i]*Math.pow(2,p);
            p++;
        }
        return res;
    }
}