// Last updated: 9/14/2025, 9:13:34 AM
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        // Step 1: Find the length of the list
        while (current != null) {
            length++;
            current = current.next;
        }
        // Step 2: Find the kth node from the beginning
        ListNode firstKNode = head;
        for (int i = 1; i < k; i++) {
            firstKNode = firstKNode.next;
        }
        // Step 3: Find the kth node from the 
        //end (which is (length - k + 1)-th from start)
        ListNode secondKNode = head;
        for (int i = 1; i < length - k + 1; i++) {
            secondKNode = secondKNode.next;
        }
        // Step 4: Swap their values
        int temp = firstKNode.val;
        firstKNode.val = secondKNode.val;
        secondKNode.val = temp;
        return head;
    }
}
