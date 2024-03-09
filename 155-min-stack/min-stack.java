class MinStack {
    //approach using pairs
    class Pair{
        int val;
        int min;
        Pair(int val,int min){
            this.val = val;
            this.min = min;
        }
    }
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
        }else{
            Pair p = stack.peek();
            int min = Integer.min(p.min,val);
            stack.push(new Pair(val,min));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek().val;
    }
    
    public int getMin() {
        if(stack.isEmpty()) return -1;
        return stack.peek().min;
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