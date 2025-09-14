// Last updated: 9/14/2025, 9:12:26 AM
class Tuple{
    int maxHeight;
    int r;
    int c;
    Tuple(int maxHeight,int r,int c){
        this.maxHeight = maxHeight;
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][]visited = new boolean[n][m];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y) -> x.maxHeight - y.maxHeight);

        pq.add(new Tuple(grid[0][0], 0, 0));
        visited[0][0] = true;
        int [][]directions = new int[][]{
            {0,1},{0,-1},{-1,0},{1,0}
        };
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int maxHeight = t.maxHeight;
            int r = t.r;
            int c = t.c;
            if(r == n-1 && c == m-1) return maxHeight;
            for(int []dir:directions){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if(isValid(nr,nc,n,m) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    pq.add(new Tuple(Integer.max(maxHeight,grid[nr][nc]),nr,nc));
                }
            }
        }

        return 0;
    }
    public boolean isValid(int nr,int nc, int n,int m){
        return nr>=0 && nc>=0 && nr<n && nc<m;
    }
}