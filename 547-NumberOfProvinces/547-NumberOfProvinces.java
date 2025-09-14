// Last updated: 9/14/2025, 9:13:26 AM
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // solving using bfs - breadth first search
        int n = isConnected.length;
        int m = isConnected[0].length;
        boolean []visited = new boolean[n];
        int provinces = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                provinces++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    Integer x = queue.poll();
                    for(int j=0;j<m;j++){
                        if(isConnected[x][j] == 1 && !visited[j]){
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
            
        }


        return provinces;
    }
}