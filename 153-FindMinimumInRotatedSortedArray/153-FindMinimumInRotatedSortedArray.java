// Last updated: 9/14/2025, 9:16:15 AM
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            //further optimization - if the array is fully sorted then don't need of binary search
            if(nums[low] <= nums[high]){
                ans = Integer.min(ans, nums[low]);
                return ans;
            }

            //first find which part is sorted either left or right
            int mid = (high-low)/2+low;

            if(nums[low]<=nums[mid]){ //left portion sorted
                //then minimum  value will be stored in leftmost part
                ans = Integer.min(ans, nums[low]);
                //then eliminate the sorted part further it is not required
                low = mid+1; 
            }else{
                //for right part left most element will be stored in mid
                ans = Integer.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}