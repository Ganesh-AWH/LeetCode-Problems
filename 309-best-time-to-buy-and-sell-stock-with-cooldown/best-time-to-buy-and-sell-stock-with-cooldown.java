class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //tabulation solution
        int [][]dp = new int[n+2][2];
        for(int index=n-1; index>=0; index--){
            for(int buy=0; buy<=1; buy++){
                int profit = 0;
                if(buy == 1){
                    int take = -prices[index] + dp[index+1][0];
                    int notTake = 0 + dp[index+1][1];
                    profit = Integer.max(notTake , take);
                }
                else{
                    int take = prices[index] + dp[index+2][1];
                    int notTake = 0 + dp[index+1][0];
                    profit = Integer.max(notTake , take);
                }
                dp[index][buy] = profit;
            }
        }
        return dp[0][1];
    }
}