// Last updated: 9/14/2025, 9:12:54 AM
class Solution {
    public int markIsland(int [][]grid,int i,int j){
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if(i<0 || j<0 || i>=rowLen || j>=colLen || grid[i][j] != 1) return 0;
        grid[i][j] = 2;
        return (1 + markIsland(grid,i-1,j) + markIsland(grid,i+1,j) + markIsland(grid,i,j-1) + markIsland(grid,i,j+1));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int max = 0;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(grid[i][j] == 1){
                    max = Math.max(max,markIsland(grid,i,j));
                }
            }
        }

        return max;
    }
}