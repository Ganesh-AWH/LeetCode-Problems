// Last updated: 9/14/2025, 9:11:03 AM
class Tuples{
    int x;
    int y;
    int dist;
    Tuples(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
        int [][]distance = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j] = (int)(1e9);
            }
        }
        Queue<Tuples> queue = new LinkedList<>();
        queue.add(new Tuples(0,0,1));
        distance[0][0] = 1;
        int [][]directions = new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
        };
        while(!queue.isEmpty()){
            Tuples t = queue.poll();
            int x = t.x;
            int y = t.y;
            int dist = t.dist;
            if(x==n-1 && y==m-1) return dist;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nx = x + i;
                    int ny = y + j;
                    if(nx>=0 && ny>=0 && nx<n && ny<m && grid[nx][ny]==0 && dist+1 < distance[nx][ny]){
                        distance[nx][ny] = dist+1;
                        queue.add(new Tuples(nx,ny,dist+1));
                    }
                }
            }
        }


        for(int []dist:distance){
            System.out.println(Arrays.toString(dist));
        }

        return -1;
    } 
}