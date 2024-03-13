class Solution {
    public String removeKdigits(String num, int k) {
        //monotonic stack 
        char []arr = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            while(!stack.isEmpty() && (stack.peek() > c && k!=0) ){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        // if k != 0 then remove the top elements
        while(k!=0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(Character x:stack){
            if(x == '0' && sb.length() == 0){
                continue;
            }else{
                sb.append(x);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}