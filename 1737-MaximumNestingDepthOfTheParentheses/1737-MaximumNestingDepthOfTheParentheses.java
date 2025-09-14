// Last updated: 9/14/2025, 9:09:34 AM
class Solution {
    public int maxDepth(String s) {
        //optimal solution
        int depth = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                depth++;
            }else if(c == ')'){
                depth--;
            }
            max = Integer.max(max,depth);
        }
        return max;
    }
}