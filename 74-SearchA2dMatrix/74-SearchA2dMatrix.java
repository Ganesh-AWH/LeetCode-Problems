// Last updated: 9/14/2025, 9:17:39 AM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Optimal approach log(m*n);
        int m = matrix.length;
        int n = matrix[0].length;
        //hypothetically think 2d as 1d array
        int low = 0;
        int high = m*n-1; 
        while(low <= high){
            int mid = low + (high - low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
}