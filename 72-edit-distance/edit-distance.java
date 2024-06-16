class Solution {
    public int minDistance(String word1, String word2) {
        // tabulation solution
        int n = word1.length();
        int m = word2.length();
        //since the base in recursion going negative shifting the index for tabulation method
        int [][]dp = new int[n+1][m+1];
        //base case conversion
        for(int j=0; j<=m; j++){
            dp[0][j] = j;
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    //since we are not performing any operaion so 0
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = Integer.min(insert, Integer.min(delete, replace));
                }

            }
        }
        return dp[n][m];
    }
}