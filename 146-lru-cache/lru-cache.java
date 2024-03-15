class LRUCache {

    Node head = new Node(-1, -1), tail = new Node(-1, -1);
    Map < Integer, Node > map = new HashMap();
    int capacity;
    class Node {
        Node prev;
        Node next;
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() >= capacity) {
            remove(tail.prev);
        }
        insert(newNode);
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */