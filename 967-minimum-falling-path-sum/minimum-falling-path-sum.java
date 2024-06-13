class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //tabulation - solution
        //variable starting point and variable ending point
        int m = matrix.length;
        int n = matrix[0].length;
        int [][]dp = new int[m][n];
        //base case converting
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }

        //recursion conversion
        for(int i=1;i<m;i++){
            //for every possible i, j runs from 0 -> n-1
            for(int j=0;j<n;j++){
                int up = matrix[i][j] + dp[i-1][j];
                int ld = matrix[i][j];
                int rd = matrix[i][j];
                if(j>0) ld += dp[i-1][j-1];
                else ld += (int)(1e9);
                
                if(j<n-1) rd += dp[i-1][j+1];
                else rd += (int)(1e9);
                dp[i][j] = Integer.min(up,Integer.min(ld,rd));
            }
        }

        int mini = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            mini = Integer.min(mini,dp[m-1][j]);
        }
        return mini;
    }
    public int recursion(int i,int j,int [][]matrix,int m,int n,int [][]dp){
        //base case
        if(j<0 || j>=n) return (int)(1e9);
        
        if(i==0){
            return matrix[i][j];
        }
        //when you go left diagonal j<0
        //when you go right diagonal j>n
        if(dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + recursion(i-1,j,matrix,m,n,dp);
        int ld = matrix[i][j] + recursion(i-1,j-1,matrix,m,n,dp);
        int rd = matrix[i][j] + recursion(i-1,j+1,matrix,m,n,dp);

        return dp[i][j] = Integer.min(up,Integer.min(ld,rd));
    }
}