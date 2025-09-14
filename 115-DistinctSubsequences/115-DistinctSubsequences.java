// Last updated: 9/14/2025, 9:17:00 AM
class Solution {
    public int numDistinct(String s, String t) {
        //tabulation solution with space optimization
        int n = s.length();
        int m = t.length();
        int []prev = new int[m+1];
        prev[0] = 1;
        for(int i=1; i<=n; i++){
            int []curr = new int[m+1];
            curr[0] = 1;
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    //call for two possibilites
                    //take the character from string-1
                    int call1 = prev[j-1];

                    //don't take the character from string1
                    int call2 = prev[j];

                    curr[j] = call1 + call2;
                }else{
                    //reduce the string1 if they dont match
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}