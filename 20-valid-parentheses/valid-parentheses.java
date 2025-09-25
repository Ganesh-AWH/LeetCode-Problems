class Solution {
    public boolean isValid(String s) {
        char []arr = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            //open bracket -> push it into the stack
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }

            //close bracket
            else{
                
                if(stack.isEmpty()) return false;

                else if(stack.peek() == '(' && c != ')') return false;
                else if(stack.peek() == '{' && c!='}') return false;
                else if(stack.peek() == '[' && c!= ']') return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();



    }
}

/*

))

*/
