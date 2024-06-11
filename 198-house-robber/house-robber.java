class Solution {
    public int rob(int[] nums) {
        //Maximum Sum of Non-Adjacent Elements - Subsequences
        //Recursion
        int []dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return recursion(nums.length-1,nums,dp); 
    }
    public int recursion(int index,int []nums,int []dp){
        if(index == 0) return nums[index];

        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];
                                        //no adjacent element
        int pick = nums[index] + recursion(index-2,nums,dp);
        int nonPick = 0 + recursion(index-1,nums,dp);

        //constraint to find max sum
        return dp[index] = Integer.max(pick,nonPick);
    }
}