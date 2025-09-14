// Last updated: 9/14/2025, 9:09:14 AM
class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n+1; i++){
            adjList.add(i, new ArrayList<>());
        }
        for(int []edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList);
        System.out.println(n);
        for(int i=1; i<adjList.size(); i++){
            if(adjList.get(i).size() == n){
                return i;
            } 
        } 

        return 0;
    }
}