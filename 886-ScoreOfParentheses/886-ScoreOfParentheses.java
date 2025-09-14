// Last updated: 9/14/2025, 9:12:06 AM
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(score);
                score = 0;
            }else{
                score = stack.pop() + Math.max(2*score,1);
            }
        }
        return score;
    }
}