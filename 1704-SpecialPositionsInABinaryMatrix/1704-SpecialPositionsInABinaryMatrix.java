// Last updated: 9/14/2025, 9:09:41 AM
class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int rowCount[] = new int[row];
        int colCount[] = new int[col];
        List<int[]> indices = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                    indices.add(new int[]{i,j});
                }
            }
        }
        int count = 0;
        for(int []index:indices){
            int r = index[0];
            int c = index[1];
            if(rowCount[r]==1 && colCount[c]==1) count++;
        }
        return count;
    }
}