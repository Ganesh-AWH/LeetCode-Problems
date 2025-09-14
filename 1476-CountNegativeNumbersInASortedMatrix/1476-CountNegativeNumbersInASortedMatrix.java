// Last updated: 9/14/2025, 9:10:11 AM
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int []arr:grid){
            int res = binarySearch(arr,0,arr.length-1);

            //since it is non increasing order
            count += res; 
        }
        return count;
    }
    private static int binarySearch(int []arr,int low,int high){
        //edge case
        if(arr[low]<0){
            return arr.length;
        }
        if(arr[high]>=0) return 0;
        int temp = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]<0){
                temp = mid;
                high = mid-1;
            }
            else low = mid+1;
        }

        return arr.length - temp;
    }
}