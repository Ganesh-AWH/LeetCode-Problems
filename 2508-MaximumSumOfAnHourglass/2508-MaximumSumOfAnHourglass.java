// Last updated: 9/14/2025, 9:08:19 AM
class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m < 3 || n< 3){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(int  i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                int sum = 0;
                // top
                sum += grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1];
                // middle
                sum += grid[i][j];
                // bottom
                sum += grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1];
                max = Integer.max(max, sum);
            }
        }

        return max;
    }
}