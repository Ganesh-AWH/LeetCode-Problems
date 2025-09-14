// Last updated: 9/14/2025, 9:18:28 AM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c = board[i][j];
                if(c!='.'){
                    if(!set.add(c+"rows"+i) || !set.add(c+"cols"+j) || !set.add(c+"subBox"+i/3+"x"+j/3)){
                        return false;
                    }

                }
            }
        }
        return true;
    }
}