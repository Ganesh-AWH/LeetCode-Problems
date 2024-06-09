class Solution {
    public int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(List<Integer> con:connections){
            int u = con.get(0);
            int v = con.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int []tin = new int[n];
        int []low = new int[n];
        boolean []visited = new boolean[n];
        dfs(0,-1,tin,low,adj,bridges,visited);
        return bridges;
    }
    public void dfs(int node,int parent,int []tin,int []low,List<List<Integer>> adj,List<List<Integer>> bridges,boolean []visited){
        visited[node] = true;
        low[node] = timer;
        tin[node] = timer;
        timer++;
        for(Integer it:adj.get(node)){
            if(it == parent) continue;

            if(!visited[it]){
                dfs(it,node,tin,low,adj,bridges,visited);
                low[node] = Integer.min(low[node],low[it]);
                if(low[it] > tin[node]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(it);
                    temp.add(node);
                    bridges.add(temp);
                }
            }else{
                low[node] = Integer.min(low[node],low[it]);
            }
        }
    }
}