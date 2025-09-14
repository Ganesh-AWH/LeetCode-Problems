// Last updated: 9/14/2025, 9:10:17 AM
class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int threshold) {
        //instead of using floyd warshal algorithm use dijikras algorithm because the path weight does not contain negative weight
        //create the graph
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int []edge:edges){
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];
            adj.get(u).add(new Pair(v,dist));
            adj.get(v).add(new Pair(u,dist));
        }
        int countCity = n;
        int cityNo = -1;
        for(int i=0;i<n;i++){
            int []dist = dijikstras(adj,n,threshold,i);
            //it counts the city which has atmost distance of threshold
            int count = 0;
            for(int j=0;j<dist.length;j++){
                if(dist[j]<=threshold){
                    count++;
                }
            }
            if(count <= countCity){
                countCity = count;
                cityNo = i;
            }
        }

        return cityNo;
    }
    public int[] dijikstras(List<List<Pair>> adj,int n,int threshold,int src){
        int []distance = new int[n];
        Arrays.fill(distance,(int)(1e9));

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);

        distance[src] = 0;
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int dist = p.dist;
            if(dist>=threshold){
                    continue;
            }
            for(Pair it:adj.get(node)){
                int adjNode = it.node;
                int edWt = it.dist;
                if(dist + edWt < distance[adjNode]){
                    distance[adjNode] = dist + edWt;
                    pq.add(new Pair(adjNode,dist+edWt));
                }
            }
        }

        return distance;
    }
}