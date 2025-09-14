// Last updated: 9/14/2025, 9:18:10 AM
class Solution {
    public List<List<String>> solveNQueens(int n) {
        //approach - 2 hashing
        List<List<String>> ans = new ArrayList<>();
        char [][]board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int []left = new int[n];
        int []upperDiagonal = new int[2 * n - 1];
        int []lowerDiagonal = new int[2 * n - 1];
        helper(0,board,ans,left,upperDiagonal,lowerDiagonal);
        return ans;
    }
    private static void helper(int col,char [][]board,List<List<String>> ans,int []left,int []upperDiagonal,int []lowerDiagonal){
        int n = board.length;
        if(col == n){
            ans.add(construct(board));
            return;
        }

        for(int row = 0;row<n;row++){
            if(left[row]==0 && upperDiagonal[row+col] == 0 && lowerDiagonal[col-row+n-1] == 0){
                board[row][col] = 'Q';
                left[row] = 1;
                upperDiagonal[row+col] = 1;
                lowerDiagonal[col-row+n-1] = 1;
                helper(col+1,board,ans,left,upperDiagonal,lowerDiagonal);
                board[row][col] = '.';
                left[row] = 0;
                upperDiagonal[row+col] = 0;
                lowerDiagonal[col-row+n-1] = 0;
            }
        }
    }
    private static List<String> construct(char [][]board){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}