class Solution {
    public int minNumberOperations(int[] target) {
        //Monotonic stack increasing stack
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int count = 0;
        for(int i:target){
            if(i > stack.peek()){
                count += i - stack.peek();
            }
            while(stack.peek() > i){
                stack.pop();
            }

            stack.push(i);
        }

        return count;
    }
}