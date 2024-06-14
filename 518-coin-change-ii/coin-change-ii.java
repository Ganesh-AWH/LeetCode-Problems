class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int[n][amount+1]; 
        //tabulation solution
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int t=0;t<=amount;t++){
            if(t%coins[0] == 0) dp[0][t] = 1;
        }

        for(int index = 1;index<n;index++){
            for(int t=0;t<=amount;t++){
                int notPick = dp[index-1][t];
                int pick = 0;
                if(coins[index]<=t){
                    pick = dp[index][t-coins[index]];
                }
                dp[index][t] = pick + notPick;
            }
        }
        return dp[n-1][amount];
    }
}