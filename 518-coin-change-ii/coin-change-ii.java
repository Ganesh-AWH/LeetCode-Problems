class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int[n][amount+1]; 
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return recursion(n-1,amount,coins,dp);
    }
    public int recursion(int index,int t,int []coins,int [][]dp){
        if(t == 0) return 1;
        if(index == 0){
            if(t % coins[0] == 0) return 1;
            else return 0;
        }
        if(dp[index][t] != -1) return dp[index][t];
        int notPick = recursion(index-1,t,coins,dp);
        int pick = 0;
        if(coins[index]<=t){
            pick = recursion(index,t-coins[index],coins,dp);
        }

        return dp[index][t] = pick + notPick;
    }
}