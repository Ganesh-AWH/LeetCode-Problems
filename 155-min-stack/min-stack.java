class Pair{
    int val;
    int min;
    //constructor
    Pair(int val, int min){
        this.val = val;
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
            Pair p = new Pair(val, val);
            stack.push(p);
        }else{
            Pair top = stack.peek();
            int min = Integer.min(val, top.min);
            Pair p = new Pair(val, min);
            stack.push(p);
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        Pair p = stack.peek();
        return p.val;
    }
    
    public int getMin() {
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