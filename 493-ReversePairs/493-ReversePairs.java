// Last updated: 9/14/2025, 9:13:47 AM
class Solution {
    public int reversePairs(int[] nums) {
        //optimal solution 
        //Using merge sort
        return mergeSort(nums,0,nums.length-1);
    }
    private static int mergeSort(int []arr,int left,int right){
        int count = 0;
        if(left>=right){
            return count;
        }
        int mid = left + (right - left)/2;
        count += mergeSort(arr,left,mid);
        count += mergeSort(arr,mid+1,right);
        count += merge(arr,left,mid,right);
        return count;
    }
    private static int merge(int []arr,int left,int mid,int right){
        int []sorted = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;
        int count = countPairs(arr,left,mid,right);
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                sorted[k] = arr[i++];
            }else{
                sorted[k] = arr[j++];
            }
            k++;
        }
        while(i<=mid){
            sorted[k++] = arr[i++];
        }
        while(j<=right){
            sorted[k++] = arr[j++];
        }
        //make in place in array
        for(k=0;k<sorted.length;k++){
            arr[k+left] = sorted[k];
        }
        return count;
    }
    private static int countPairs(int []arr,int left,int mid,int right){
        int count = 0;
        int j = mid+1;
        for(int i=left;i<=mid;i++){
            while(j<=right && (long)arr[i] > 2L * arr[j]){
                j++;
            }
            count += j - (mid+1);
        }
        return count;
    }
}