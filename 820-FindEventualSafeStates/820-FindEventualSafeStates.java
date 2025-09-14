// Last updated: 9/14/2025, 9:12:17 AM
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //step 1 rever the graph
        int V = graph.length;
        List<List<Integer>> reversedAdj = new ArrayList<>();
        for(int i=0;i<V;i++) reversedAdj.add(new ArrayList<>());
        
        int []indegree = new int[V];
        for(int i=0;i<V;i++){
            // i -> j
            // j -> i
            for(int j:graph[i]){
                reversedAdj.get(j).add(i);
                //step 2 find the indegree of the reversed graph
                indegree[i]++; 
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        //push the nodes which has indegree = 0
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                queue.add(i);
                safeNodes.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i:reversedAdj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                    safeNodes.add(i);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}