// Last updated: 9/14/2025, 9:07:26 AM
class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && Character.isDigit(c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c:stack){
            sb.append(c);
        }
        return sb.toString();
    }
}