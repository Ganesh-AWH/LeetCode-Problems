// Last updated: 9/14/2025, 9:08:54 AM
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length) return new int[0][];

        int [][]res = new int[m][n];
        int x = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j] = original[x++];
            }
        }

        return res;
    }
}