// Last updated: 9/14/2025, 9:18:32 AM
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        //Binary search 
        while(low<=high){
            int mid = (high-low)/2+low;
            if(nums[mid] == target) return mid;
            //first check left half is sorted
            if(nums[low]<=nums[mid]){ // -> if this condition satisfied then left is sorted
                //check the target lies in the left region
                if(target>=nums[low] && target<=nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            // if the first if condtion does not works then right half is sorted
            else{
                //check the target lies in the right region
                if(target>=nums[mid] && target<=nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}