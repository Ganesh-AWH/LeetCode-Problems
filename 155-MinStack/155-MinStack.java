// Last updated: 9/14/2025, 9:16:12 AM
class Pair{
    int value;
    int min;
    Pair(int value, int min){
        this.value = value;
        this.min = min;
    }
}
class MinStack {
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            //keeping the first element as min
            stack.push(new Pair(val, val));
        }
        else{
            Pair p = stack.peek();
            //compare the value and stack's minimum value
            int min = Integer.min(val, p.min);
            stack.push(new Pair(val, min));
        }   
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        Pair p = stack.peek();
        return p.value;
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;
        Pair p = stack.peek();
        return p.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */