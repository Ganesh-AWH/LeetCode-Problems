// Last updated: 9/14/2025, 9:18:20 AM
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        //tabulation solution
        int [][]dp = new int[n+1][m+1];
        //base case conversion
        dp[0][0] = 1;
        for(int i=1; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j=1; j<=m; j++){
            int flag = 1;
            for(int jj=1; jj<=j; jj++){
                if(p.charAt(jj-1) != '*'){
                    flag = 0;
                    break;
                }
            }
            dp[0][j] = flag;
        }   

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                char c1 = s.charAt(i-1);
                char c2 = p.charAt(j-1);

                if(c1 == c2 || c2 == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }

                else if(c2 == '*'){
                    int call1 = dp[i-1][j];
                    int call2 = dp[i][j-1];

                    dp[i][j] = call1 == 1 || call2 == 1 ? 1 : 0;
                }

                else dp[i][j] = 0;
            }
        }
        return dp[n][m] == 1;
    }
}