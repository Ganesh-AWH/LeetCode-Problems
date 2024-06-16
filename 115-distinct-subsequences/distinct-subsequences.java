class Solution {
    public int numDistinct(String s, String t) {
        //tabulation solution solution
        int n = s.length();
        int m = t.length();
        int [][]dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    //call for two possibilites
                    //take the character from string-1
                    int call1 = dp[i-1][j-1];

                    //don't take the character from string1
                    int call2 = dp[i-1][j];

                    dp[i][j] = call1 + call2;
                }else{
                    //reduce the string1 if they dont match
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}