class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = Integer.MIN_VALUE;
        for(int ind=0; ind<n; ind++){
            for(int prev=0; prev<ind; prev++){
                if(nums[prev] < nums[ind]){
                    dp[ind] = Integer.max(dp[prev]+1 , dp[ind]);
                }                
            }
            maxi = Integer.max(maxi, dp[ind]);
        }

        return maxi;
    }
}