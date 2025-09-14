// Last updated: 9/14/2025, 9:12:12 AM
class MyCircularQueue {
    int []queue;
    int count;
    int size;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        queue = new int[k];
        count = 0;
        size = k;
        front = -1;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if(count == size) return false;
        if(rear == -1){
            front = 0;
            rear = 0;
        }else{
            rear = (rear+1) % size;
        }
        count++;
        queue[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(count == 0) return false;
        count--;
        front = (front + 1) % size;
        return true;
    }
    
    public int Front() {
        if(count == 0) return -1;
        return queue[front%size];
    }
    
    public int Rear() {
        if(count == 0) return -1;
        return queue[rear%size];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */