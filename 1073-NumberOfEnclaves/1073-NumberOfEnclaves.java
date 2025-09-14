// Last updated: 9/14/2025, 9:11:17 AM
class Solution {
    int [][]directions = new int[][]{
        {0,-1},{0,1},{1,0},{-1,0}
    };
    public int numEnclaves(int[][] grid) {
        //to solve this problem under stand surrounded region problem
        int n = grid.length;
        int m = grid[0].length;

        boolean [][]visited = new boolean[n][m];

        //columns
        for(int i=0;i<n;i++){
            //first column
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(grid,visited,i,0,n,m);
            }

            //last column
            if(grid[i][m-1] == 1 && !visited[i][m-1]){
                dfs(grid,visited,i,m-1,n,m);
            }
        }

        for(int j=0;j<m;j++){
            //first row
            if(grid[0][j] == 1 && !visited[0][j]){
                dfs(grid,visited,0,j,n,m);
            }

            if(grid[n-1][j] == 1 && !visited[n-1][j]){
                dfs(grid,visited,n-1,j,n,m);
            }
        }

        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == 1) count++;
            }
        }

        return count;
    }
    public void dfs(int [][]grid,boolean [][]visited,int i,int j,int n,int m){
        visited[i][j] = true;

        for(int []dir:directions){
            int ni = i + dir[0];
            int nj = j + dir[1];

            if(ni>=0 && nj>=0 && ni<n && nj<m && !visited[ni][nj] && grid[ni][nj] == 1){
                dfs(grid,visited,ni,nj,n,m);
            }
        }
    }
}