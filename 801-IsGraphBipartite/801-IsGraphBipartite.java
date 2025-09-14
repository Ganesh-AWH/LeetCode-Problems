// Last updated: 9/14/2025, 9:12:23 AM
class Solution {
    public boolean isBipartite(int[][] graph) {
        //solving using dfs algorithm
        //bipartite states that the graph is coloured using only two colors

        int n = graph.length;
        int []visited = new int[n];
        Arrays.fill(visited,-1);
        //graph is colored int two colors either 0 or 1;
        for(int i=0;i<n;i++){
            if(visited[i] == -1){
                if(dfs(graph,i,visited,0) == false) return false;
            }
        }

        return true;
    }
    public boolean dfs(int [][]graph,int node,int []graphColor,int color){
        //color the node
        graphColor[node] = color;
        //change the color for the next node

        for(int i:graph[node]){
            //the graph is not colored so color it
            if(graphColor[i] == -1){
                if(dfs(graph,i,graphColor,1-color)==false) return false;
            }
            //the graph is colored and two adjacent colors are equal
            else if(graphColor[i] == color) return false;
        }

        return true;
    }
}