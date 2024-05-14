class Solution {
    int [][]directions = new int[][]{
        {1,0},{-1,0},{0,1},{0,-1}
    };
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int r = grid.length;
        int c = grid[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] != 0)
                    maxGold = Integer.max(maxGold,dfs(grid,i,j,r,c));
            }
        }

        return maxGold;
    }
    public int dfs(int [][]grid,int x,int y,int r,int c){
        if(x<0 || y<0 || x>=r || y>=c || grid[x][y] == 0) return 0;

        int curr = grid[x][y];
        grid[x][y] = 0;
        int gold = curr;

        for(int []dir:directions){
            int newX = x + dir[0];
            int newY = y + dir[1];

            gold = Integer.max(gold,curr + dfs(grid,newX,newY,r,c));
        }

        grid[x][y] = curr;

        return gold;
    }
}