// Last updated: 9/14/2025, 9:14:49 AM
class NumMatrix {
    int prefix[][];
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        prefix = new int[m][n];

        //col-wise sum
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0)
                    prefix[i][j] = matrix[i][j];
                else 
                    prefix[i][j] = matrix[i][j] + prefix[i-1][j];
            }
        }

        //row-wise sum
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }

        for(int []mat:prefix){
            System.out.println(Arrays.toString(mat));
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int topRegion = row1==0?0:prefix[row1-1][col2];
        int leftRegion = col1==0?0:prefix[row2][col1-1];
        int topLeftRegion = row1==0 || col1==0? 0: prefix[row1-1][col1-1];
        return prefix[row2][col2] - topRegion - leftRegion + topLeftRegion;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */