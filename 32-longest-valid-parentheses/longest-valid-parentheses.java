class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        char []arr = s.toCharArray();
        stack.push(-1);
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Integer.max(max, i-stack.peek());
                }
            }
        }
        return max;
    }
}