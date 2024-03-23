class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int freshOranges = 0;
        int time = 0;
        Queue<int []> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int [][]directions = new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
        while(!queue.isEmpty() && freshOranges > 0){
            time++;
            int size = queue.size();
            while(size-->0){
                int []index = queue.poll();
                for(int []dir:directions){
                    int r = index[0] + dir[0];
                    int c = index[1] + dir[1];
                    if(r<0 || c<0 || r>=row || c>=col || grid[r][c] != 1) continue;

                    queue.add(new int[]{r,c});
                    grid[r][c] = 2;
                    freshOranges--;
                }
            }
        }


        return freshOranges == 0 ? time : -1;
    }
}