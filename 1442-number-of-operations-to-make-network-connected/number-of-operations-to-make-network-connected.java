class Disjoint{
    int []size;
    int []parent;
    Disjoint(int n){
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0;i<n;i++){
            size[i] = 1;
            parent[i] = i;
        }
    }
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    public void findBySize(int u,int v){
        //ultimate parent of u
        int pu = findParent(u);
        //ultimate parent of v
        int pv = findParent(v);

        if(pu == pv) return;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        //if the size is equal then we can do anything 
        else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extraEdges = 0;
        Disjoint ds = new Disjoint(n);
        for(int []con:connections){
            int u = con[0];
            int v = con[1];
            if(ds.findParent(u) == ds.findParent(v)){
                extraEdges++;
            }else{
                ds.findBySize(u, v);   
            }
        }

        int []parent = ds.parent;
        //finding the number of components
        int nc = 0;
        for(int i=0;i<parent.length;i++){
            if(i == parent[i]){
                nc++;
            }
        }

        return extraEdges >= nc-1 ? nc-1 : -1;
    }
}