// Last updated: 9/14/2025, 9:12:55 AM
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack();

        for(String s:operations){
            if(s.equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            }else if(s.equals("D")){
                stack.push(stack.peek()*2);
            }else if(s.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.valueOf(s));
            }
        }

        int ans=0;
        for(int i:stack){
            ans+=i;
        }
        return ans;
    }
}