// Last updated: 9/14/2025, 9:07:20 AM
class Solution {
    public int minimumArea(int[][] grid) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        boolean found = false;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    found = true;
                    minRow = Integer.min(minRow, i);
                    maxRow = Integer.max(maxRow, i);
                    maxCol = Integer.max(maxCol, j);
                    minCol = Integer.min(minCol, j);
                }
            }
        }
        
        if(!found) return 0;
        
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        
        return height * width;
    }
}