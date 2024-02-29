class MyLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    int size;
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index <0 || index>=size) return -1;
        if(size == 1) return head.data;
        
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index<=0){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }else{
            size++;
            Node temp = head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    public void deleteAtIndex(int index) {
        if(index <0 || index>=size) return;
        size--;
        if(index == 0){
            Node delNode = head;
            head = head.next;
            delNode = null;
            return;
        }else{
            Node temp = head;
            for(int i=0;i<index-1;i++){
                temp = temp.next;
            }
            Node delNode = temp.next;
            temp.next = temp.next.next;
            delNode = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */