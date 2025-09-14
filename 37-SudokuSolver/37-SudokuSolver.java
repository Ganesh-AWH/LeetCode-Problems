// Last updated: 9/14/2025, 9:18:27 AM
class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    private static boolean helper(char [][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j] == '.'){

                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j] = c;
                            if(helper(board)) return true;
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(char [][]board,int row,int col,int ele){
        for(int i=0;i<9;i++){
            if(ele == board[row][i]) return false;
            if(ele == board[i][col]) return false;
            if(ele == board[3*(row/3)+i/3][3*(col/3)+i%3]) return false;
        }
        return true;
    }
}