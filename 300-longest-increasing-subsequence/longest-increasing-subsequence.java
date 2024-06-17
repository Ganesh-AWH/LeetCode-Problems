class Solution {
    public int lengthOfLIS(int[] nums) {
        //Memoization solution
        int n = nums.length;
                            //n+1 because of index is going negative
        int [][]dp = new int[n][n+1];
        for(int []row: dp) Arrays.fill(row, -1);
        return recursion(0, -1, nums, dp);
    }
    public int recursion(int index, int prevIndex, int []nums, int [][]dp){
        //base case
        if(index == nums.length) return 0;
        //not taking the element
        if(dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];
        int notPick = 0 + recursion(index+1, prevIndex, nums, dp);
        //taking the element
                            //since subsequence should be increasing
        int pick = Integer.MIN_VALUE;
        if(prevIndex == -1 || nums[prevIndex] < nums[index]){
                                            //marking the index as previous
            pick = 1 + recursion(index+1, index, nums, dp);
        }

        return dp[index][prevIndex+1] = Integer.max(pick, notPick);
    }
}