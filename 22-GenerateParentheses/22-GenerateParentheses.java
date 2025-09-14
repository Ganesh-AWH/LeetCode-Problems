// Last updated: 9/14/2025, 9:18:52 AM
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        //maintain open bracktes and closed brackets
        helper(n,ans,new ArrayList<>(),0,0);
        return ans;
    }
    private static void helper(int n,List<String> ans,List<Character> temp,int opened,int closed){
        if(opened == n && closed == n){
            StringBuilder sb = new StringBuilder();
            for(char c:temp) sb.append(c);
            ans.add(sb.toString());
            return;
        }

        //add the open brackets if opened < n
        //add close brackets if closed < opened
        if(opened < n){
            temp.add('(');
            helper(n, ans, temp, opened+1, closed);
            temp.remove(temp.size()-1);
        }
        if(closed < opened){
            temp.add(')');
            helper(n, ans, temp, opened, closed+1);
            temp.remove(temp.size()-1);
        }
    }
}