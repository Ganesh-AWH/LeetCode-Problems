// Last updated: 9/14/2025, 9:12:44 AM
class Solution {
    int [][]directions = new int[][]{
        {0,1},{1,0},{-1,0},{0,-1}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //solving using bfs algorithm
        int n = image.length;
        int m = image[0].length;
        int initial = image[sr][sc];
        int [][]ans = image;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while(!queue.isEmpty()){
            int []indices = queue.poll();
            int x = indices[0];
            int y = indices[1];
            ans[x][y] = color;
            for(int []dir:directions){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m && image[nx][ny]!=color && image[nx][ny]==initial){
                    queue.add(new int[]{nx,ny});
                }
            }
        }

        return ans;
    }
}