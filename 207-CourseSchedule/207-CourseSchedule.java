// Last updated: 9/14/2025, 9:15:40 AM
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //to solve this problem we can use bfs algorithm the graph contains cycle or not


        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(i,new ArrayList<>());
        for(int []p:prerequisites){
            adj.get(p[0]).add(p[1]);
        }

        //topo sort - khan's algorithm
        int []indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0) queue.add(i);
        }
        List<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            order.add(node);
            for(int i:adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }

        return order.size()==numCourses;
    }
}