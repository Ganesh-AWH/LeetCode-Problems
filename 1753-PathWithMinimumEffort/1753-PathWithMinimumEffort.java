// Last updated: 9/14/2025, 9:09:32 AM
class Tuples{
    int r;
    int c;
    //difference
    int diff;
    Tuples(int diff,int r,int c){
        this.diff = diff;
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int [][]distance = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j] = (int)(1e9);
            }
        }

        PriorityQueue<Tuples> pq = new PriorityQueue<>((x,y) -> x.diff - y.diff);
        pq.add(new Tuples(0,0,0));
        distance[0][0] = 0;
        int [][]directions = new int[][]{
            {0,1},{0,-1},{-1,0},{1,0}
        };
        while(!pq.isEmpty()){
            Tuples t = pq.poll();
            int r = t.r;
            int c = t.c;
            int diff = t.diff;
            if(r == n-1 && c == m-1){
                return diff;
            }
            for(int []dir:directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newEffort = Integer.max(diff,Math.abs(heights[r][c] - heights[nr][nc]));
                    if(newEffort<distance[nr][nc]){
                        distance[nr][nc] = newEffort;
                        pq.add(new Tuples(newEffort,nr,nc));
                    }
                }
            }
        }
        return 0;
    }
}