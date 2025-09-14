// Last updated: 9/14/2025, 9:18:04 AM
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        //four pointers
        int top = 0;
        int bottom = row-1;
        int left = 0;
        int right = col-1;
        int count = 0;
        while(count!=row*col){
            //left to right
            for(int i=left;i<=right && count!=row*col;i++){
                ans.add(matrix[top][i]);
                count++;
            }
            top++;
            //top to bottom
            for(int i=top;i<=bottom && count!=row*col;i++){
                ans.add(matrix[i][right]);
                count++;
            }
            right--;
            //right to left
            for(int i=right;i>=left && count!=row*col;i--){
                ans.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            //bottom to top
            for(int i=bottom;i>=top && count!=row*col;i--){
                ans.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return ans;
    }
}