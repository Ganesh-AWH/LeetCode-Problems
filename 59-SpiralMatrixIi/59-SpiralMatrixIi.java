// Last updated: 9/14/2025, 9:17:58 AM
class Solution {
    public int[][] generateMatrix(int n) {
        int [][]ans = new int[n][n];

        if(n==1){
            return new int[][]{{1}};
        }
        //four pointers
        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = n-1;

        int printNum  = 1;
        while(printNum<=n*n){
            //left to right
            for(int i=left;i<=right && printNum<= n*n ;i++){
                ans[top][i] = printNum++; 
            }
            top++;

            //top to bottom
            for(int i=top;i<=bottom && printNum<=n*n;i++){
                ans[i][right] = printNum++;
            }
            right--;
            //right to left
            for(int i=right;i>=left && printNum<=n*n;i--){
                ans[bottom][i] = printNum++;
            }
            bottom--;

            //bottom to top
            for(int i=bottom;i>=top && printNum<=n*n;i--){
                ans[i][left] = printNum++;
            }
            left++;
        }
        return ans;
    }
}