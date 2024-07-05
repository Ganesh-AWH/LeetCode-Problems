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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> cpoints = new ArrayList<>();
        ListNode prev = head;
        ListNode curr = head.next;
        //one based index
        int index = 2;
        while(curr.next != null){
            // is minima
            if(prev.val > curr.val && curr.val < curr.next.val){
                cpoints.add(index);
            }
            //is maxima
            else if(prev.val < curr.val && curr.val >  curr.next.val){
                cpoints.add(index);
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        System.out.println(cpoints);
        if(cpoints.size() <= 1){
            return new int[]{-1, -1};
        }
        int []ans = new int[2];
        int mini = Integer.MAX_VALUE;
        //check for adjacent values
        for(int i=1; i<cpoints.size(); i++){
            mini = Integer.min(mini, cpoints.get(i) - cpoints.get(i-1));
        }
        
        int maxi = cpoints.get(cpoints.size()-1) - cpoints.get(0);
        return new int[]{mini, maxi};
    }
}