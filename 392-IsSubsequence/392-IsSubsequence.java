// Last updated: 9/14/2025, 9:14:21 AM
class Solution {
    public boolean isSubsequence(String s, String t) {
        int left=0,right=0;
        if(s.length()<1){
            return true;
        }
        while(left<s.length() && right<t.length()){
            if(s.charAt(left)==t.charAt(right)){
                left++;
            }
            right++;
        }
        return left==s.length();
    }
}