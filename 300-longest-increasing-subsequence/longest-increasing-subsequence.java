class Solution {
    public int lengthOfLIS(int[] nums) {
        //tabulation solution
        int n = nums.length;
        int [][]dp = new int[n+1][n+1];

        for(int index=n-1; index>=0; index--){
            for(int prevIndex=index-1; prevIndex>=-1; prevIndex--){
                int notPick = 0 + dp[index+1][prevIndex+1];
                int pick = Integer.MIN_VALUE;
                if(prevIndex == -1 || nums[prevIndex] < nums[index]){
                    pick = 1 + dp[index+1][index+1];
                }

                dp[index][prevIndex+1] = Integer.max(pick, notPick);
            }
        }
        return dp[0][0];
    }
}