class MyStack {
    //stack using 2 queues in coding ninja verify that also

    //stack using single queue
    //frist push the element into the queue
    //if size > 1 remove top element and again push into the queue
    Queue<Integer> queue;
    int size;
    public MyStack() {
        queue = new LinkedList<>();
        size = 0;
    }
    
    public void push(int x) {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++){
            int ele = queue.remove();
            queue.add(ele);
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */