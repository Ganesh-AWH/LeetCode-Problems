// Last updated: 9/14/2025, 9:11:36 AM
class Disjoint{
    int []size;
    int []parent;
    Disjoint(int n){
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0;i<=n;i++){
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
    public int removeStones(int[][] stones) {
        int maxRows = 0;
        int maxCols = 0;
        for(int []stone:stones){
            maxRows = Integer.max(maxRows,stone[0]);
            maxCols = Integer.max(maxCols,stone[1]);
        }

        //the no of nodes are maxRows + maxCols + 1;
        int nodes = maxRows + maxCols + 1;
        Disjoint ds = new Disjoint(nodes);
        //storing all the nodes that are used 
        Set<Integer> set = new HashSet<>();
        for(int []stone : stones){
            int u = stone[0];
            int v = stone[1] + maxRows + 1;
            ds.findBySize(u,v);
            set.add(u);
            set.add(v);
        }

        int count = 0;
        for(Integer i:set){
            if(ds.findParent(i) == i){
                //claculates the number of components
                count++;
            }
        }
        //total number of stones
        int stonesCount = stones.length;
        return stonesCount - count;
    }
}
/*
Derivation
c1 = x1, c2 = x2, c3 = x3 ...
x1+x2+x3+... = n stones
the stones to be removed is 
(x1-1) + (x2-1) + (x3-1) + ....
(x1+x2+x3+...) - (no of components)
ie total no of stones - no of components  
the components that contains x stones 

*/