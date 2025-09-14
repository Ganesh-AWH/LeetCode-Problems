// Last updated: 9/14/2025, 9:09:43 AM
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        //sort the edges because 3 is common for both alice and bob
        Arrays.sort(edges, (a, b)-> b[0]-a[0]);
        Disjoint alice = new Disjoint(n);
        Disjoint bob = new Disjoint(n);
        int addEdge = 0;
        for(int []edge: edges){
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            //both alice and bob path
            if(type == 3){
                if(alice.unionBySize(u, v) | bob.unionBySize(u, v)){
                    addEdge++;
                }
            }
            //bob path
            else if(type == 2){
                if(bob.unionBySize(u, v)){
                    addEdge++;
                }
            }else{
                if(alice.unionBySize(u, v)){
                    addEdge++;
                }
            }
        }
        System.out.println(addEdge);

        return (alice.isDistinct() && bob.isDistinct()) ? edges.length - addEdge : -1;
    }
    
}
class Disjoint{
    int []size;
    int []parent;
    int distinctComponents;
    Disjoint(int n){
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            size[i] = 1;
            parent[i] = i;
        }
        distinctComponents = n;
    }
    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    public boolean unionBySize(int u,int v){
        //ultimate parent of u
        int pu = findParent(u);
        //ultimate parent of v
        int pv = findParent(v);

        if(pu == pv) return false;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        //if the size is equal then we can do anything 
        else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        distinctComponents--;
        return true;
    }
    public boolean isDistinct(){
        return distinctComponents == 1;
    }
}
