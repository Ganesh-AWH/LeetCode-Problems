class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        //memoization solution
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        int ans = recursion(n-1,amount,coins,dp);        
        return ans >= 1e9 ? -1 : ans;
    }
    public int recursion(int index,int amount,int []coins,int [][]dp){
        if(index == 0){
            if(amount%coins[0] == 0){
                return amount/coins[0];
            }else{
                return (int)(1e9);
            }
        }
        if(dp[index][amount] != -1) return dp[index][amount];
        //not picking up the coin so 0
        int notPick = 0 + recursion(index-1,amount,coins,dp);
        int pick = (int)(1e9);
        if(coins[index] <= amount){
            //picking up the coin so 1
            pick = 1 + recursion(index,amount-coins[index],coins,dp);
        }
        return dp[index][amount] = Integer.min(notPick, pick);
    }
}