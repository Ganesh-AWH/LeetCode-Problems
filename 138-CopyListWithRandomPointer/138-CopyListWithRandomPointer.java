// Last updated: 9/14/2025, 9:16:32 AM
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //approach - 2
        //traverse - 1 insert copy nodes in between 
        Node temp = head;
        while(temp!=null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        
        //traverse - 2 solving random pointers
        temp = head;
        while(temp!=null){
            temp.next.random = temp.random==null?null:temp.random.next;
            temp = temp.next.next;
        }

        //traverse - 3 connect next pointers
        temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}