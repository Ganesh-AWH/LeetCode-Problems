// Last updated: 9/14/2025, 9:15:37 AM
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(i,new ArrayList<>());
        for(int []p:prerequisites){
            //the order is changes 0,1 to take 0 you have to take 1
            adj.get(p[1]).add(p[0]);
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
        int []order = new int[numCourses];
        int x = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            order[x++] = node;
            for(int i:adj.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        return x == numCourses ? order : new int[]{};
    }
}