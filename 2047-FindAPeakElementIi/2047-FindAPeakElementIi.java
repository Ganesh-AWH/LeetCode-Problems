// Last updated: 9/14/2025, 9:09:07 AM
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        //binarysearch00 row wise
        int m = mat.length;
        int n = mat[0].length;

        int s = 0;
        int e = m-1;
        while(s<=e){
            int mid = s + (e - s)/2;
            int col = findMax(mat,mid);
            int top = mid-1>=0?mat[mid-1][col]:-1;
            int bottom = mid+1<m?mat[mid+1][col]:-1;
            if(mat[mid][col]>top && mat[mid][col]>bottom){
                return new int[]{mid,col};
            }
            if(top>mat[mid][col]){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    private static int findMax(int [][]arr,int row){
        int maxValue = Integer.MIN_VALUE;
        int mIndex = -1;
        for(int i=0;i<arr[0].length;i++){
            if(maxValue<arr[row][i]){
                maxValue = arr[row][i];
                mIndex = i;
            }
        }
        return mIndex;
    }
}
