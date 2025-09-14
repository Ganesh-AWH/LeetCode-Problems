// Last updated: 9/14/2025, 9:07:23 AM
class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(stack.isEmpty()) stack.push(c);

            else if(stack.peek() == c && stack.size()<9){
                stack.push(c);
                if(stack.size() == 9){
                    sb.append(9);
                    sb.append(stack.peek());
                    stack.clear();
                }
            }
            else if(stack.peek() != c){
                sb.append(stack.size());
                sb.append(stack.peek());
                stack.clear();
                stack.push(c);
            }
        }
        if(!stack.isEmpty()){
            sb.append(stack.size());
            sb.append(stack.peek());

        }
        System.out.println(stack);
        return sb.toString();
    }
}