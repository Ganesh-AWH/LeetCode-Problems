// Last updated: 9/14/2025, 9:18:03 AM
class Solution {
    public boolean canJump(int[] nums) {
        //two pointers approach
        int i = nums.length - 2;
        int j = nums.length - 1;

        for(;i>=0;i--){
            int distance = j-i;
            if(nums[i] >= distance){
                j = i;
            }
        }
        return j==0;
    }
}