// Last updated: 9/14/2025, 9:18:08 AM
class Solution {
    public int totalNQueens(int n) {
        char [][]board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        return helper(0, board);
    }
    public int helper(int col, char [][]board){
        if(col == board.length) return 1;

        int count = 0;
        for(int row=0; row<board.length; row++){
            if(isPossible(row, col, board)){
                board[row][col] = 'Q';
                count += helper(col+1, board);
                board[row][col] = '.';
            }    
        }

        return count;
    }
    public boolean isPossible(int row, int col, char [][]board){
        int dr = row;
        int dc = col;

        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = dr;
        col = dc;
        while(row>=0 && col>=0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dr;
        col = dc;
        while(row<board.length && col>=0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

}