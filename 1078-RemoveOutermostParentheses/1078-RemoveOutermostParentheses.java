// Last updated: 9/14/2025, 9:11:16 AM
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        char []arr = s.toCharArray();
        int balance = 0;

        // c == '(' add +1
        // c == ')' reduce -1
        for(char c: arr){
            if(c == '('){
                if(balance > 0){
                    sb.append(c);
                }
                balance+=1;
            }else{
                balance -= 1;
                if(balance > 0){
                    sb.append(')');
                }
            }
        }

        return sb.toString();
    }
}