// Last updated: 9/14/2025, 9:18:18 AM
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        //greedy approach
        int far = 0; //this pointer how far i can go
        int jumps = 0;
        //marking the last jump index
        int lastIndex = 0;
        for(int i=0;i<nums.length;i++){
            //how far i can able to jump
            int maxJump = i + nums[i];
            //marking the max jumps
            far = Math.max(far,i+nums[i]);
            if(i == lastIndex){
                lastIndex = far;
                jumps++;
                if(far >= nums.length-1) return jumps;
            }
        }

        return 0;
    
    }
}