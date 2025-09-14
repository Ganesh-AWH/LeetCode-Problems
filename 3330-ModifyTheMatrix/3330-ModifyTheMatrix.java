// Last updated: 9/14/2025, 9:07:40 AM
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        List<Integer> maxCol = new ArrayList<>();
        
        for(int j=0;j<c;j++){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<r;i++){
                max = Integer.max(max,matrix[i][j]);
            }
            maxCol.add(max);
        }
        System.out.print(maxCol);
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = maxCol.get(j);
                }
            }
        }
        return matrix;
    }
}