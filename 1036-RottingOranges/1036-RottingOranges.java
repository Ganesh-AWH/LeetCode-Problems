// Last updated: 9/14/2025, 9:11:24 AM
class Solution {
    int [][]directions = new int[][]{
        {0,1},{0,-1},{-1,0},{1,0}
    };
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int freshOranges = 0;
        int time = 0;
        Queue<int []> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()  && freshOranges>0){
            int size = queue.size();
            time++;
            for(int i=0;i<size;i++){
                int []indices = queue.poll();
                int x = indices[0];
                int y = indices[1];

                for(int []dir:directions){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==1){
                        //mark it has visited
                        freshOranges--;
                        grid[nx][ny] = 2;
                        queue.add(new int[]{nx,ny});
                    }
                }
            } 
        }

        return freshOranges == 0 ? time : -1;
    }
}