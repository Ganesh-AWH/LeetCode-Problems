// Last updated: 9/14/2025, 9:09:58 AM
class Solution {
    public int[] runningSum(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i]=sum;
        }
        return nums;
    }
}