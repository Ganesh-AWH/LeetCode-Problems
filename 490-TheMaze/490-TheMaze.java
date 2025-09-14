// Last updated: 9/14/2025, 9:13:48 AM
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int [][]directions = new int[][]{
            {1,0},{0,1},{-1,0},{0,-1}
        };
        return helper(maze,destination,start[0],start[1],directions);
    }
    private static boolean helper(int [][]maze,int []destination,int i,int j,int [][]directions){
        //if rolling ball stops in the destination
        int row = maze.length;
        int col = maze[0].length;

        //if the ball stops in the wall or some other postion
        if(maze[i][j]== 1 || maze[i][j] == -1) return false;

        //if ball particularly stops in the destination 
        if(i==destination[0] && j == destination[1]){
            return true;
        }

        //-1 is the ball track
        maze[i][j] = -1;

        for(int []dir:directions){
            //check if the next path contains wall
            int x = i+dir[0];
            int y = j+dir[1];
            //ball is rolling until it reaches the wall
            while(x>=0 && y>=0 && x<row && y<col && maze[x][y]!=1){
                x += dir[0]; 
                y += dir[1];
            }
            //at the end of the wall the ball is in the wall

            //one step back
            x -= dir[0];
            y -= dir[1];

            //check if ball stops on destination
            if(helper(maze,destination,x,y,directions)){
                return true;
            }
        }

        //the ball does not stop at the destination
        return false; 
    }
}