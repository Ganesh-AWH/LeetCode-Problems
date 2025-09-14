// Last updated: 9/14/2025, 9:11:53 AM
class StockSpanner {
    Stack<Pair<Integer,Integer>> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!stack.isEmpty() && stack.peek().getKey() <= price){
            Pair<Integer,Integer> p = stack.pop();
            count += p.getValue();
        }
        stack.push(new Pair<>(price,count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */