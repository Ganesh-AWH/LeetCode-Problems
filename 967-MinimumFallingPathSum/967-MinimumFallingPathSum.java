// Last updated: 9/14/2025, 9:11:43 AM
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //tabulation - solution with space optimization
        //variable starting point and variable ending point
        int m = matrix.length;
        int n = matrix[0].length;
        int []prev = new int[n];
        //base case converting
        for(int j=0;j<n;j++){
            prev[j] = matrix[0][j];
        }

        //recursion conversion
        for(int i=1;i<m;i++){
            int []curr = new int[n];
            //for every possible i, j runs from 0 -> n-1
            for(int j=0;j<n;j++){
                int up = matrix[i][j] + prev[j];
                int ld = matrix[i][j];
                int rd = matrix[i][j];
                if(j>0) ld += prev[j-1];
                else ld += (int)(1e9);
                
                if(j<n-1) rd += prev[j+1];
                else rd += (int)(1e9);
                curr[j] = Integer.min(up,Integer.min(ld,rd));
            }
            prev = curr;
        }

        int mini = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            mini = Integer.min(mini,prev[j]);
        }
        return mini;
    }
}