// Last updated: 9/14/2025, 9:16:44 AM
class Solution {
    int [][]directions = new int[][]{
        {0,1},{0,-1},{-1,0},{1,0}
    };
    public void solve(char[][] board) {
        //start the dfs algorithm from the boundaries of 'O'
        //mark all the connected boundaries '0' that cannot be flipped
        int n = board.length;
        int m = board[0].length;
        boolean [][]visited = new boolean[n][m];
        //rows
        for(int j=0;j<m;j++){
            //first rows
            if(board[0][j]=='O' && !visited[0][j]){
                dfs(board,visited,0,j);
            }

            //last rows 
            if(board[n-1][j] == 'O' && !visited[n-1][j]){
                dfs(board,visited,n-1,j);
            }
        }

        //rows
        for(int i=0;i<n;i++){
            //first column
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(board,visited,i,0);
            }

            if(board[i][m-1] == 'O' && !visited[i][m-1]){
                dfs(board,visited,i,m-1);
            }
        }
        

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char [][]board,boolean [][]visited,int i,int j){
        visited[i][j] = true;

        for(int []dir:directions){
            int ni = i + dir[0];
            int nj = j + dir[1];

            if(ni>=0 && nj>=0 && ni<board.length && nj<board[0].length && board[ni][nj]=='O' && !visited[ni][nj]){
                dfs(board,visited,ni,nj);
            }
        }
    }
}