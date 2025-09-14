// Last updated: 9/14/2025, 9:08:39 AM
class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i<n;i++){
            Set<Integer> row = new HashSet<>();
            Set<Integer> column = new HashSet<>();
            for(int j=0;j<n;j++){
                row.add(matrix[i][j]);
                column.add(matrix[j][i]);
            }
            if(row.size()!=n || column.size()!=n) return false;
        }
    return true;
    }
}