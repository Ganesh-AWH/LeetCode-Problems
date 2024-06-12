class Solution {
    public int uniquePaths(int m, int n) {
        //DP solution
        //top down approach
        int [][]dp = new int[m][n];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return recursion(m-1,n-1,dp);
    }
    public int recursion(int i,int j,int [][]dp){
        //we have reached the end
        if(i == 0 && j== 0){
            return 1;
        }
        //base case
        if(i<0 || j<0) return 0;
        //up
        if(dp[i][j] != -1) return dp[i][j];
        int up = recursion(i-1,j,dp);
        int left = recursion(i,j-1,dp);

        return dp[i][j] = up + left;
    }
}