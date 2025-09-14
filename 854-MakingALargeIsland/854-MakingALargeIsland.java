// Last updated: 9/14/2025, 9:12:13 AM
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
    public void unionBySize(int u,int v){
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
    public int largestIsland(int[][] grid) {
        //for this you have to use only union by size
        //first connect the components which have 1 
        int n = grid.length;
        int m = grid[0].length;
        Disjoint ds = new Disjoint(n * m);
        int [][]directions = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
        };
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    //connect the components
                    for(int []dir:directions){
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if(isValid(nr,nc,n,m) && (grid[nr][nc] == 1)){
                                int nodeNo = i * m + j;
                                int adjNo = nr * m + nc;
                                ds.unionBySize(nodeNo,adjNo);
                        }
                    }
                }
            }
        }

        // if the node is zero go for four direction and find for big size component
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    for(int []dir:directions){
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if(isValid(nr,nc,n,m) && grid[nr][nc] == 1){
                            int adjNo = nr * m + nc;
                            int parent = ds.findParent(adjNo);
                            set.add(parent);
                        }
                    }
                    int size = 1;
                    for(Integer x : set){
                        size += ds.size[x];
                    }
                    max = Integer.max(max,size);
                }
            }
        }

        for(int i=0;i<n*n;i++){
            int parent = ds.findParent(i);
            max = Integer.max(max,ds.size[parent]);
        }

        return max;      
    }
    public boolean isValid(int nr,int nc,int n,int m){
        return nr>=0 && nc>=0 && nr<n && nc<m;
    }
}