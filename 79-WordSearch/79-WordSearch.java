// Last updated: 9/14/2025, 9:17:33 AM
class Solution {
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == first){
                    if(dfs(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    private static boolean dfs(char [][]board,int i,int j,String word,int index){
        if(index == word.length()) return true;
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(index<word.length() && board[i][j]!=word.charAt(index)) return false;
        board[i][j]='.';
        boolean flag = dfs(board,i+1,j,word,index+1) ||
        dfs(board,i,j+1,word,index+1) ||
        dfs(board,i-1,j,word,index+1) ||
        dfs(board,i,j-1,word,index+1);
        board[i][j]=word.charAt(index);
        return flag;
    }
}