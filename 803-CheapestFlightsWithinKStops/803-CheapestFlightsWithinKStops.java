// Last updated: 9/14/2025, 9:12:21 AM
class Tuples{
    int stops;
    int node;
    int dist;
    Tuples(int stops,int node,int dist){
        this.stops = stops;
        this.node = node;
        this.dist = dist;
    }

}
class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []flight:flights){
            int u = flight[0];
            int v = flight[1];
            int dist = flight[2];
            adj.get(u).add(new Pair(v,dist));
        }
        int []distance = new int[n];
        Arrays.fill(distance,(int)(1e9));

        //use dijikstras algoirthm based on stops greedy about stops and then distance;
        //dont use priority queue because stops are incresing in constant 
        Queue<Tuples> queue = new LinkedList<>();
        queue.add(new Tuples(0,src,0));
        distance[src] = 0;
        while(!queue.isEmpty()){
            Tuples t = queue.poll();
            int node = t.node;
            int stops = t.stops;
            int dist = t.dist;
            if(stops >k) continue;
            for(Pair p:adj.get(node)){
                int adjNode = p.node;
                int edgWt = p.dist;
                if(dist+edgWt < distance[adjNode] && stops<=k){
                    distance[adjNode] = dist+edgWt;
                    queue.add(new Tuples(stops+1,adjNode,dist+edgWt));
                }
            }
        }

        return distance[dst] == (int)(1e9) ? -1 : distance[dst];
    }
}