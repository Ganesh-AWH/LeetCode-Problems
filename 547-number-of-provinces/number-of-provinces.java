class Solution {
    public int findCircleNum(int[][] isConnected) {
        //solving without creating adjacency list
        int n = isConnected.length;
        int m = isConnected[0].length;

        boolean []visited = new boolean[n];
        int provinces = 0;
        for(int i=0;i<n;i++){

            if(!visited[i]){
                provinces++;
                dfs(i,visited,isConnected);
            }
        }
        return provinces;
    }
    public void dfs(int node,boolean []visited,int [][]isConnected){
        visited[node] = true;

        for(int i=0;i<isConnected[0].length;i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                dfs(i,visited,isConnected);
            }
        }
    }
}