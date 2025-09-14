// Last updated: 9/14/2025, 9:18:23 AM
class Solution {
    public int firstMissingPositive(int[] nums) {
        //Base condition
        boolean flag = false;
        for(int i:nums){
            if(i == 1){
                flag = true;
                break;
            }
        }
        if(!flag) return 1;

        int max = nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i] > max) nums[i] = 1;
        }

        for(int i=0;i<nums.length;i++){
            //to use index make as key make it as possitive always
            int a = Math.abs(nums[i]);

            if(a == max) nums[0] = - Math.abs(nums[0]);

            else nums[a] = - Math.abs(nums[a]);

        }

        for(int i=1;i<max;i++){
            if(nums[i] > 0) return i;
        }

        if(nums[0] > 0) return max;

        return max+1;
    }
}