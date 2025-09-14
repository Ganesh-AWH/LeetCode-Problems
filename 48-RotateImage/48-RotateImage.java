// Last updated: 9/14/2025, 9:18:15 AM
class Solution {
    public void rotate(int[][] matrix) {
        //Approach-2

        //step-1 transporse the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse the every row
        for(int[] row:matrix){
            int p1 = 0;
            int p2 = row.length-1;
            while(p1<p2){
                int temp = row[p1];
                row[p1] = row[p2];
                row[p2] = temp;
                p1++;
                p2--;
            }
        }

    }
}
/*
step -1 transporse the given matrix
step -2 reverse the every row 
*/