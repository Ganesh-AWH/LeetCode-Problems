// Last updated: 9/14/2025, 9:07:57 AM
//solving the problem using these algorithms
//bfs, binary search 
class Solution {
    int [][]directions = new int[][]{
        {1,0},{0,1},{-1,0},{0,-1}
    };
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int r = grid.size();
        int c = grid.get(0).size();
        int [][]distance = new int[r][c];
        //find the minimum distance to the theif 
        int length = findDistance(distance,grid);
        for(int []dis:distance){
            System.out.println(Arrays.toString(dis));
        }

        //binary search to find safness factor 
        int low = 0;
        int high = length;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isSafe(distance,mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    public int findDistance(int [][]distance,List<List<Integer>> grid){
        int n = grid.size();
        Queue<int[]> queue = new LinkedList<>();
        boolean [][]visited = new boolean[n][n];
        //first adding theifs into the queue
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j) == 1){
                    visited[i][j] = true;
                    queue.add(new int[]{i,j});
                }
            }
        }

        int len = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int []index = queue.poll();
                int x = index[0];
                int y = index[1];   
                distance[x][y] = len; 
                for(int []dir:directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    //check for boundary conditions i used different function to check
                    if(isValid(newX,newY,visited)){
                       visited[newX][newY] = true;
                       queue.add(new int[]{newX,newY});
                    }
                }
            }
            len++;   
        }
        return len;
    }
    public boolean isValid(int x,int y,boolean [][]visited){
        if(x<0 || x>=visited.length || y<0 || y>=visited[0].length || visited[x][y]) return false;

        return true;
    }
    public boolean isSafe(int [][]distance,int safeFactor){
        //check the condition if the path has distance[i] >= safeFactor

        //using dfs to find the path
        System.out.println(safeFactor); 
        int n = distance.length;
        if(distance[0][0] < safeFactor) return false;
        boolean [][]visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int []index = queue.poll();
            int x = index[0];
            int y = index[1];
            if(x == n-1 && y == n-1) return true;

            for(int []dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(isValid(newX,newY,visited)){
                    //if condition satisfies then we need to check for another element
                    if(distance[newX][newY] < safeFactor) continue;
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX,newY});
                }
            }
        }

        return false;
    }
}