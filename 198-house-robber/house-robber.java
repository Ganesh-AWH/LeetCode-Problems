class Solution {
    public int rob(int[] nums) {
        //Maximum Sum of Non-Adjacent Elements - Subsequences
        //Tabulation
        int []dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            // int pick = nums[index] + dp[index-2];
            int pick = nums[i];
            if(i>1){
                pick += dp[i-2];
            }
            int nonPick = 0 + dp[i-1];
            dp[i] = Integer.max(pick,nonPick);
        }
        return dp[nums.length-1]; 
    }
}