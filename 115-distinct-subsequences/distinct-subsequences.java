class Solution {
    public int numDistinct(String s, String t) {
        //recursion solution
        int n = s.length();
        int m = t.length();
        int [][]dp = new int[n][m];
        for(int []row:dp){
            Arrays.fill(row, -1);
        }
        return recursion(n-1, m-1, s, t, dp);
    }
    public int recursion(int i, int j, String s, String t, int [][]dp){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        //if the both the character matches
        if(s.charAt(i) == t.charAt(j)){
            //call for two possibilites
            //take the character from string-1
            int call1 = recursion(i-1, j-1, s, t, dp);

            //don't take the character from string1
            int call2 = recursion(i-1, j, s, t, dp);

            return dp[i][j] = call1 + call2;
        }else{
            //reduce the string1 if they dont match
            return dp[i][j] = recursion(i-1, j, s, t, dp);
        }
    }
}