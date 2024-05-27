class Solution {
    public int findCircleNum(int[][] isConnected) {
        //solving by converting matrix into adjList
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(i,new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(i!=j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        int provinces = 0;
        boolean []visited = new boolean[isConnected.length+1];
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                provinces++;
                dfs(i,visited,adj);
            }
        }

        return provinces;
    }
    public void dfs(int node,boolean []visited,List<List<Integer>> adj){
        visited[node] = true;

        for(Integer i:adj.get(node)){
            if(!visited[i]){
                dfs(i,visited,adj);
            }
        }
    }
}