// Last updated: 9/14/2025, 9:15:02 AM
class Solution {
    public int[] singleNumber(int[] nums) {
        //first find the xor of all the elements
        int xor = 0;
        for(int i:nums) xor = xor ^ i;

        int mask = xor & ~(xor-1);
        int ans1 = 0;
        int ans2 = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & mask)!=0){
                ans1 = ans1 ^ nums[i];
            }else{
                ans2 = ans2 ^ nums[i];
            }
        }

        return new int[]{ans1,ans2};
    }
}