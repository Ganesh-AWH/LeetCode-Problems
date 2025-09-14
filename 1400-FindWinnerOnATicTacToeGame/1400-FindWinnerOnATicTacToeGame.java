// Last updated: 9/14/2025, 9:10:32 AM
class Solution {
    public static boolean determineWinner(char [][]board,char player){
        for(int i=0;i<board.length;i++){
            //row check
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            //column check
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        //diagonal check - 1
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        
        //diagonal check - 2
        if(board[2][0] == player && board[1][1] == player && board[0][2] == player)
            return true;
        
        return false;
    }
    public String tictactoe(int[][] moves) {
        
        //creatring board 
        char [][]board = new char[3][3];
        char player = 'X';

        for(int []move:moves){
            int row = move[0];
            int column = move[1];
            board[row][column] = player;
            player = player=='X'? 'O' : 'X';
        }

        if(determineWinner(board,'X')) return "A";
        if(determineWinner(board,'O')) return "B";

        if(moves.length == 9) return "Draw";
        else return "Pending";
    }
}