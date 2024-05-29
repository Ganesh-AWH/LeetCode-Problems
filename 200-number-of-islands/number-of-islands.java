class Solution {
    int [][]directions = new int[][]{
        {1,0},{-1,0},{0,-1},{0,1}
    };
    public int numIslands(char[][] grid) {
        //bfs 
        int count = 0;
        Queue<int []> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    queue.add(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int []indices = queue.poll();
                        int x = indices[0];
                        int y = indices[1];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
                            continue;
                        }
                        
                        grid[x][y] = '0';
                        for(int []dir:directions){
                            int newX = dir[0] + x;
                            int newY = dir[1] + y;
                            if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && grid[newX][newY]=='1'){
                                queue.add(new int[]{newX,newY});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}