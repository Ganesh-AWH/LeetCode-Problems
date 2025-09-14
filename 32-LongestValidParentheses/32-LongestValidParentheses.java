// Last updated: 9/14/2025, 9:18:34 AM
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char []arr = s.toCharArray();
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Integer.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}