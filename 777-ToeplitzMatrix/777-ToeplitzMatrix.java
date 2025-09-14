// Last updated: 9/14/2025, 9:12:36 AM
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                
                if(matrix[i-1][j-1]!=matrix[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}