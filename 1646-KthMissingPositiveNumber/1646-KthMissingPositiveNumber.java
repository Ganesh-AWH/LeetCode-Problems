// Last updated: 9/14/2025, 9:09:49 AM
class Solution {
    public int findKthPositive(int[] arr, int k) {
       int low = 0;
       int high = arr.length-1;
       while(low<=high){
            int mid = (high - low)/2 + low;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
       }
       //missing = arr[high] - (high+1);
       //more = k -  missing
       //more = k -  (arr[high] - (high+1))
       //ans -> arr[high] + more
       //ans -> arr[high] + k - (arr[high] - (high+1))
       //ans -> arr[high] + k - arr[high] + (high+1)
       //ans -> k + 1 + high
       return k+1+high;
    }
}