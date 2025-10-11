class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        char []arr = num.toCharArray();

        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(stack.isEmpty() && c != '0'){
                stack.push(c);
                continue;
            }
            while(!stack.isEmpty() && k>0 && stack.peek() > c){
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
            if(c == '0' && sb.length() == 0) continue;
            else sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}