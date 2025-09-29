class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for(int i=0; i<pushed.length; i++){
            int ele = pushed[i];
            stack.push(ele);
            while(!stack.isEmpty() && j<popped.length && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }

        return j == popped.length;
    }
}