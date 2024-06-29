class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
        for(int []edge: edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(v).add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            boolean []visited = new boolean[n];
            dfs(adjList, i, temp, visited);
            Collections.sort(temp);
            ans.add(temp);
        }
        return ans;
    }
    public void dfs(List<List<Integer>> adjList, int src, List<Integer> temp, boolean []visited){
        visited[src] = true;
        for(Integer i: adjList.get(src)){
            if(!visited[i]){
                temp.add(i);
                dfs(adjList, i, temp, visited);
            }
        }
    }
}