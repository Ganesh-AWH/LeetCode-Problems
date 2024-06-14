class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        //tabulation solution
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for(int a=0;a<=amount;a++){
            if(a % coins[0] == 0) dp[0][a] = a/coins[0];
            else dp[0][a] = (int)(1e9);
        }
        for(int index=1;index<n;index++){
            for(int a=0;a<=amount;a++){
                int notPick = 0 + dp[index-1][a];
                int pick = (int)(1e9);
                if(coins[index] <= a){
                        //picking up the coin so 1
                    pick = 1 + dp[index][a-coins[index]];
                }
                dp[index][a] = Integer.min(notPick, pick);
            }
        }
        int ans = dp[n-1][amount];        
        return ans >= 1e9 ? -1 : ans;
    }
}