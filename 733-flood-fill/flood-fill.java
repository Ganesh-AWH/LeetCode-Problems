class Solution {
    int [][]directions = new int[][]{
        {0,1},{0,-1},{-1,0},{1,0}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //mark the initial color 
        int n = image.length;
        int m = image[0].length;
        int initial = image[sr][sc];
        dfs(image,sr,sc,initial,color,n,m);

        return image;
    }
    public void dfs(int [][]image,int i,int j,int initial,int newColor,int n,int m){
        image[i][j] = newColor;

        for(int []dir:directions){
            int nI = i + dir[0];
            int nJ = j + dir[1];
            if(nI>=0 && nJ>=0 && nI<n && nJ<m && image[nI][nJ] != newColor && image[nI][nJ] == initial){
                dfs(image,nI,nJ,initial,newColor,n,m);
            }
        }
    }
}