// Last updated: 9/14/2025, 9:16:21 AM
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        //it carries the operators to validate with input
        Set<String> set = new HashSet<>();
        //adding all operators to set
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for(String token: tokens){
            if(!set.contains(token)){
                //converting string to integer
                int num = Integer.parseInt(token);
                stack.push(num);
            }else{
                int num2 = stack.pop();
                int num1 = stack.pop(); 
                if(token.equals("+")){
                    stack.push(num1 + num2);
                }else if(token.equals("-")){
                    stack.push(num1 - num2);
                }else if(token.equals("*")){
                    stack.push(num1 * num2);
                }else{
                    stack.push(num1 / num2);
                }
            }
        }
        return stack.pop();
    }
}