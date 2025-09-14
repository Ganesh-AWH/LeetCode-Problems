// Last updated: 9/14/2025, 9:19:20 AM
class Solution {
    public String longestPalindrome(String s) {
        //Brute force appraoch
        int len = s.length();
        String ans = "";
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                String sub = s.substring(i,j+1);
                if(isPossible(sub,0,sub.length()-1)){
                    if(ans.length()<sub.length()) ans = sub;
                }
            }
        }
        return ans;
    }
    private static boolean isPossible(String str,int s,int e){
        while(s<e){
            if(str.charAt(s)!=str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}