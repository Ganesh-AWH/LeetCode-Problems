// Last updated: 9/14/2025, 9:16:09 AM
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        //handling edge cases
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int s = 1;
        int e = n-2;
        while(s<=e){
            int mid = s + (e - s)/2;
            if(nums[mid]>nums[mid-1] &&  nums[mid]>nums[mid+1]){
                return mid;
            }
            //check whether graph is increasing or decreasing
            //if the graph is increasing then peak will at right side
            if(nums[mid]>nums[mid-1]){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return -1;
    }
}