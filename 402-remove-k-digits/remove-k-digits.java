class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<num.length(); i++){
            char c = num.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            while(!stack.isEmpty() && (k!=0 && stack.peek() > c)){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while(k!=0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(Character c: stack){
            if(c == '0' && sb.length() == 0){
                continue;
            }else{
                sb.append(c);
            }
        }
        return sb.length() == 0? "0": sb.toString();
    }
}