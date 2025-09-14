// Last updated: 9/14/2025, 9:15:29 AM
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number * 10 + (int) (c-'0');
        }else if(c == '+'){
            result += sign*number;
            number = 0;
            sign = 1;
        }else if(c == '-'){
            result += sign * number;
            number = 0;
            sign = -1;
        }else if(c == '('){
            //push result first and then sign
            stack.push(result);
            stack.push(sign);

            //reset sign & result
            sign = 1;
            result = 0;
        }else if(c == ')'){
            result += sign * number;
            number = 0;
            result *= stack.pop(); //sign multiplication
            result += stack.pop(); //adding the number
        }
        }
        if(number != 0) result += sign * number;
        return result; 
    }
}