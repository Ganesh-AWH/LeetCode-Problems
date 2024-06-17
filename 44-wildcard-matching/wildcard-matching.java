class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int [][]dp = new int[n][m];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        return recursion(n-1, m-1, s, p, dp) == 1 ;
    }
    public int recursion(int i, int j, String s, String p, int [][]dp){
        //base case
        if(i < 0 && j < 0) return 1;

        if(i>=0 && j<0) return 0;
        
        if(i < 0 && j>=0){
            for(; j>= 0; j--){
                if(p.charAt(j) != '*') return 0;
            }
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];

        char c1 = s.charAt(i);
        char c2 = p.charAt(j);

        if(c1 == c2 || c2 == '?'){
            return dp[i][j] = recursion(i-1, j-1, s, p, dp);
        }

        if(c2 == '*'){
            int call1 = recursion(i-1, j, s, p, dp);
            int call2 = recursion(i, j-1, s, p, dp);

            return dp[i][j] = call1 == 1 || call2 == 1 ? 1 : 0;
        }

        return dp[i][j] = 0;
    }
}