// Last updated: 9/14/2025, 9:11:38 AM
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        //it keeps track of popped array
        int j = 0;
        for(int i=0; i<pushed.length; i++){
            int ele = pushed[i];
            //first push the element into the stack
            stack.push(ele);

            //check the top of the popped element and top of stack 
            while(!stack.isEmpty() && j<popped.length && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }

        return j == popped.length;
    }
}