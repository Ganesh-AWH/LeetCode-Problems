// Last updated: 9/14/2025, 9:14:19 AM
class Solution {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stack = new Stack<>();

        int num = 0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            else if(c == '['){
                numStack.push(num);
                num = 0;
                stack.push(ans);
                ans = new StringBuilder();
            }
            else if(c == ']'){
                StringBuilder temp = ans;
                ans = stack.pop();
                int count = numStack.pop();
                while(count-- > 0){
                    ans.append(temp);
                }
            }else{
                ans.append(c);
            }
        }

        return ans.toString();
    }
}

//Process
/*
1.) if character is number then (num = num * 10 + c - '0') --> this is for double digit number

2.) if character is '[' then push number and string builder to the stacks respectively

3.) if character is ']' then pop number and stringbuilder from stacks respectively

4.) if it is character then append it to the answer
 */