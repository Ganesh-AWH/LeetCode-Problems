// Last updated: 9/14/2025, 9:12:41 AM
class Pair{
    int node;
    int dist;
    Pair(int dist,int node){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        int []distance = new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
            distance[i] = (int)(1e9);
        }

        for(int []time:times){
            adj.get(time[0]).add(new Pair(time[2],time[1]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        distance[k] = 0;
        pq.add(new Pair(0,k));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int dist = p.dist;
            for(Pair it:adj.get(node)){
                int adjNode = it.node;
                int edgWt = it.dist;
                if(dist+edgWt < distance[adjNode]){
                    distance[adjNode] = dist+edgWt;
                    pq.add(new Pair(dist+edgWt,adjNode));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            max = Integer.max(distance[i],max);
        }
        return max == (int)(1e9) ? -1 : max;
    }
} 