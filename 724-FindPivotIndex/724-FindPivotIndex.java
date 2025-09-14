// Last updated: 9/14/2025, 9:12:52 AM
class Solution {
    public int pivotIndex(int[] nums) {
        int left_sum=0,tot=0;
        for(int x:nums){
            tot+=x;
        }
        for(int i=0;i<nums.length;i++){
            if(left_sum==(tot-nums[i]-left_sum)){
                return i;
            }
            left_sum+=nums[i];
        }
        return -1;
    }
}