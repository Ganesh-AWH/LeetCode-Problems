// Last updated: 9/14/2025, 9:16:14 AM
class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int s = 0;
        int e = nums.length-1;

        while(s<=e){
            int mid = s + (e - s)/2;
            if(nums[s] == nums[mid] && nums[mid] == nums[e]){
                min = Integer.min(min,nums[s]);
                s++;
                e--;
                continue;
            }
            if(nums[s]<=nums[mid]){
                min = Integer.min(min,nums[s]);
                s = mid+1;
            }else{
                min = Integer.min(min,nums[mid]);
                e = mid-1;
            }
        }
        return min;
    }
}