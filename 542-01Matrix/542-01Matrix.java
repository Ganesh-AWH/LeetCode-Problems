// Last updated: 9/14/2025, 9:13:29 AM
class Triples{
    int x;
    int y;
    int lvl;
    Triples(int x,int y,int lvl){
        this.x = x;
        this.y = y;
        this.lvl = lvl;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean [][]visited = new boolean[n][m];
        Queue<Triples> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    queue.add(new Triples(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        int [][]ans = new int[n][m];
        int [][]directions = new int[][]{
            {0,-1},{0,1},{1,0},{-1,0}
        };
        while(!queue.isEmpty()){
            Triples t = queue.poll();
            int x = t.x;
            int y = t.y;
            int lvl = t.lvl;
            ans[x][y] = lvl;
            for(int []dir:directions){
                int nx = x+dir[0];
                int ny = y+dir[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny]){
                    queue.add(new Triples(nx,ny,lvl+1));
                    visited[nx][ny] = true;
                }
            }
        }

        return ans;
    }
}