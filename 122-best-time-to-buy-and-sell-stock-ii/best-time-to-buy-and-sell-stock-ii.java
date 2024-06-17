class Solution {
    public int maxProfit(int[] prices) {
        //tabulation solution
        int n = prices.length;
        int [][]dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int index=n-1; index>=0; index--){
            for(int buy = 1; buy>=0; buy--){
                int profit = 0;
                if(buy == 1){
                    int take = -prices[index] + dp[index+1][0];
                    int notTake = 0 + dp[index+1][1];
                    profit = Integer.max(take, notTake);
                }else{
                    int take = +prices[index] + dp[index+1][1];
                    int notTake = 0 + dp[index+1][0];
                    profit = Integer.max(take, notTake);
                }

                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }
}