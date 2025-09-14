// Last updated: 9/14/2025, 9:07:43 AM
class Solution {
    public int countKeyChanges(String s) {
        Stack<Character> stack = new Stack<Character>();
        char []str = s.toCharArray();
        int count = 0;
        for(char c:str){
            char a = Character.toLowerCase(c);
            if(stack.empty()){
                stack.push(a);
            }
            else if(stack.peek()==a){
                stack.pop();
                stack.push(a);
            }else{
                // System.out.print(stack);
                stack.push(a);
                count++;
            }
        }
        System.out.print(stack);
        return count;
    }
}