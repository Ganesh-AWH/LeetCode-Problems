// Last updated: 9/14/2025, 9:18:57 AM
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char []paranthesis = s.toCharArray();

        for(char c: paranthesis){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                else if(c == '}' && stack.pop() != '{') return false;
                else if(c == ']' && stack.pop() != '[') return false;
                else if(c == ')' && stack.pop() != '(') return false;
            }
        }
        return stack.isEmpty();
    }
}