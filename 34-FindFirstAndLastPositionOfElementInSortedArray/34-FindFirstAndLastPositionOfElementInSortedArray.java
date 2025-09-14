// Last updated: 9/14/2025, 9:18:29 AM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //lower bound and upper bound approach

        //lower bound
        int s = 0;
        int e = nums.length-1;
        int lower = nums.length;
        int upper = nums.length;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid]>=target){
                lower = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        if(lower==nums.length || nums[lower]!=target) return new int[]{-1,-1};

        //find upper bound
        s = 0;
        e = nums.length-1;

        while(s<=e){
            int mid = s + (e - s)/2;
            if(nums[mid]>target){
                upper = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return new int[]{lower,upper-1};

    }
}