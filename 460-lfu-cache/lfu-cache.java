class LFUCache {
        //total capacity
        final int capacity;
        //curr capacity of elements
        int currSize;
        //it stores the least frequecy 
        int minFrequency;
        //stores frequecy and lru cache
        Map<Integer,DoublyLinkedList> freqList;
        //stores all the nodes and its address to use in get function
        Map<Integer,Node> cache;
        LFUCache(int capacity) {
            // Write your code here.
            this.capacity = capacity;
            this.currSize = 0;
            this.minFrequency = 0;
            freqList = new HashMap<>();
            cache = new HashMap<>();
        }

        //get the node from cache and update its frequecy if it is present else return -1
        public int get(int key) {
            // Write your code here.
            if(cache.containsKey(key)){
                Node currNode = cache.get(key);
                updateNode(currNode);
                return currNode.value;
            }else{
                return -1;
            }
        }
        public void put(int key, int value) {
            // Write your code here.
            //corner case
            if(capacity == 0) return;
            if(cache.containsKey(key)){
                Node node = cache.get(key);
                node.value = value;
                updateNode(node);
            }else{
                currSize++;
                if(currSize > capacity){
                    //get the minimum frequecy list 
                    DoublyLinkedList list = freqList.get(minFrequency);
                    cache.remove(list.tail.prev.key);
                    list.remove(list.tail.prev);
                    currSize--;
                }
                //reset minfrequecy to 1 because adding new node
                minFrequency=1;
                Node newNode = new Node(key,value);
                //get the frequency list of frequecy 1
                DoublyLinkedList list = freqList.getOrDefault(1,new DoublyLinkedList());
                list.add(newNode);
                freqList.put(1,list);
                cache.put(key,newNode);
            }
        }
        public void updateNode(Node node){
            //first taking currNode frequecy
            int freq = node.freq;
            //curr frequency taking the list
            DoublyLinkedList list = freqList.get(freq);
            list.remove(node);
            if(node.freq == minFrequency && list.size == 0){
                minFrequency++;
            }
            node.freq++;
            //add the currNode the another frequecy list
            DoublyLinkedList newList = freqList.getOrDefault(node.freq, new DoublyLinkedList());
            newList.add(node);
            freqList.put(node.freq,newList);
        }

    }
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        int freq;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }

    }
    class DoublyLinkedList{
        int size;
        Node head;
        Node tail;
        DoublyLinkedList(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }

        //add node the list
        public void add(Node node){
            Node headNext = head.next;
            head.next = node;
            node.next = headNext;
            node.prev = head;
            headNext.prev = node;
            size++;
        }

        //remove the node from the list;
        public void remove(Node node){
            Node delNode = node;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            delNode = null;
            size--;
        }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */