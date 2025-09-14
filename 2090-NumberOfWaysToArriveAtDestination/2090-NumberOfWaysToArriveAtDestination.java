// Last updated: 9/14/2025, 9:09:01 AM
class Pair{
    long node;
    long dist;
    Pair(long node,long dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        //creating graph adj List
        long []distance = new long[n];
        int []ways = new int[n];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            distance[i] = Long.MAX_VALUE / 2;
            adj.add(new ArrayList<>());
        }
        for(int road[]:roads){
            adj.get(road[0]).add(new Pair(road[1],road[2])); 
            adj.get(road[1]).add(new Pair(road[0],road[2])); 
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Long.compare(x.dist , y.dist));
        pq.add(new Pair(0,0));
        distance[0] = 0;
        ways[0] = 1;
        int mod = (int)(1e9 + 7);
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            long node = p.node;
            long dist = p.dist;
            for(Pair it:adj.get((int)node)){
                long adjNode = it.node;
                long edWt = it.dist;
                if(dist+edWt < distance[(int)adjNode]){
                    distance[(int)adjNode] = dist + edWt;
                    pq.add(new Pair(adjNode,dist+edWt));
                    ways[(int)adjNode] = ways[(int)node];
                }else if(dist+edWt == distance[(int)adjNode]){
                    ways[(int)adjNode] = (ways[(int)adjNode] + ways[(int)node]) % mod;
                }
            }
        }

        return ways[n-1] % mod;
    }
}