class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp - topdown approach (memoization)
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][]dp = new int[m][n];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return recursion(m-1,n-1,obstacleGrid,dp);
    }
    public int recursion(int i,int j,int [][]grid,int [][]dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(i>=0 && j>=0 && grid[i][j] == 1) return dp[i][j] = 0;
        if(i==0 && j==0) return dp[i][j] = 1;
        
        int up = recursion(i-1,j,grid,dp);
        int left = recursion(i,j-1,grid,dp);

        return dp[i][j] = up + left;
    }
}