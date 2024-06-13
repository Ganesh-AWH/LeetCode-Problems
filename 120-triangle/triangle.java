class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //tabulation - solution
        int n = triangle.size();
        int [][]dp = new int[n][n];

        //base case
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Integer.min(down,diagonal);
            }
        }
        return dp[0][0];
    }
}