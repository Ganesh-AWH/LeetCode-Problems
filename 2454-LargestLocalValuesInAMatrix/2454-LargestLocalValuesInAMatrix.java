// Last updated: 9/14/2025, 9:08:22 AM
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][]ans = new int[row-2][col-2];
        for(int i=0;i<row-2;i++){
            for(int j=0;j<col-2;j++){
                ans[i][j] = findGreatest(grid,i,i+2,j,j+2);
            }
        }
        return ans;
    }
    public static int findGreatest(int [][]grid,int iStart,int iEnd,int jStart,int jEnd){
        int max = Integer.MIN_VALUE;
        for(int i=iStart;i<=iEnd;i++){
            for(int j=jStart;j<=jEnd;j++){
                max = Integer.max(max,grid[i][j]);
            }
        }
        return max;
    }
}