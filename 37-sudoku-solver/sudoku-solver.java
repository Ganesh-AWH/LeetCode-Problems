class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public static boolean solve(char [][]board){

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                
                if(board[i][j] == '.'){
                    //trying all possible ways
                    for(char k='1'; k<='9'; k++){

                        if(isPossible(board, i, j, k)){
                            board[i][j] = k;
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }

                    }

                    return false;
                }

            }
        }

        return true;
    }
    public static boolean isPossible(char [][]board, int row, int col, char c){
        for(int i=0; i<9; i++){

            //row
            if(board[i][col] == c) return false;
            
            //col
            if(board[row][i] == c) return false;

            //finding row and column for 3X3 box
            int boxRow = 3 * (row/3) + i/3;
            int boxCol = 3 * (col/3) + i%3;
            if(board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}