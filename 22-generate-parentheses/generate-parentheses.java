class Solution {
    public List<String> generateParenthesis(int n) {
        //brute force approach
        List<String> ans = new ArrayList<>();
        generateAll(new String(), ans, n);
        return ans;
    }
    public static void generateAll(String str, List<String> ans, int n){
        if(str.length() >= 2*n){
            if(isValid(str))
                ans.add(str);
            return;
        }

        generateAll(str+"(", ans, n);
        generateAll(str+")", ans, n);
    }
    public static boolean isValid(String str){
        int paranthesis = 0;
        for(char c: str.toCharArray()){
            if(c == '('){
                paranthesis++;
            }else{
                paranthesis--;
                if(paranthesis<0) return false;
            }
        }
        return paranthesis == 0;
    }
}