// Last updated: 9/14/2025, 9:17:43 AM
class Solution {
    public String simplifyPath(String path) {
        //use stack to solve this problem
        Stack<String> stack = new Stack<>();

        String []directories = path.split("/");

        for(String dir:directories){
            if(dir.equals("") || dir.equals(".") || stack.isEmpty() && dir.equals("..")) continue;

            if(dir.equals("..")){
                stack.pop();
            }else{
                stack.push(dir);
            }
        }
        // System.out.println(stack);
        StringBuilder ans = new StringBuilder();
        for(String s:stack){
            ans.append("/");
            ans.append(s);
        }
        return ans.toString().isEmpty()? "/" : ans.toString();
    }
}