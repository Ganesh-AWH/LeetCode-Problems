// Last updated: 9/14/2025, 9:15:11 AM
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //better solution

        int row = matrix.length;
        int col = matrix[0].length;

        for(int[] mat:matrix){
            if(mat[0]==target || mat[mat.length-1]==target) return true;
            
            else if(mat[0]<target && mat[mat.length-1]>target){
                boolean flag = binarySearch(mat,0,mat.length-1,target);
                if(flag) return flag;
            }
        }
        return false;
        
    }
    private static boolean binarySearch(int []arr,int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target) return true;
            else if(arr[mid]>target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
    //TC:O(N*logN)
}