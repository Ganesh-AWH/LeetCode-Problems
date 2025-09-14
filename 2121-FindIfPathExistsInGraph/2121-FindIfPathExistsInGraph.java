// Last updated: 9/14/2025, 9:08:56 AM
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        Map<Integer,List<Integer>> map = new HashMap<>();
        //creating adjacency list
        for(int []edge:edges){
            if(!map.containsKey(edge[0])){
                map.put(edge[0],new ArrayList<>());
            }
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<>());
            }

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        //checking source and destination - BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean hasPath = false;
        queue.add(source);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            List<Integer> edge = map.containsKey(vertex) ? map.get(vertex) : new ArrayList<>();
            boolean flag = false;
            for(int i=0;i<edge.size();i++){
                if(edge.get(i) == destination){
                    flag = true;
                    break;
                }
                queue.add(edge.get(i));
            }
            map.remove(vertex);
            if(flag){
                hasPath = true;
            }
        }

        return hasPath;
    }
}