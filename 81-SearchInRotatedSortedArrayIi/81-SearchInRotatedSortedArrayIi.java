// Last updated: 9/14/2025, 9:17:31 AM
class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = (high-low)/2+low;
            if(nums[mid] == target) return true;

            //since the array is non-decreasing order the below condition will help to find the sorted half of the array
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }

            //rotated sorted array - 1 conditions
            if(nums[low]<=nums[mid]){ //left portion is sorted
                if(target>=nums[low] && target<=nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{ //right portion is sorted
                if(target<=nums[high] && target>=nums[mid]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}