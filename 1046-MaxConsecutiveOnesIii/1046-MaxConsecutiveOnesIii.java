// Last updated: 9/14/2025, 9:11:21 AM
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int zerosCount = 0;
        int length = 0;
        while(r<nums.length){
            if(nums[r] == 0) zerosCount++;
            while(zerosCount > k){
                if(nums[l] == 0) zerosCount--;
                l++;
            }
            length = Integer.max(length,r-l+1);
            r++;
        }
        return length;
    }
}