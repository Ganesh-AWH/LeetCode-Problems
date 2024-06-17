class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //recursion solution
        int [][]dp = new int[n][2];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        return recursion(0, 1, prices, dp);
    }
    public int recursion(int index, int buy, int []prices, int [][]dp){
        //base case
        if(index >= prices.length) return 0; 
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1){
            int take = -prices[index] + recursion(index+1, 0, prices, dp);
            int notTake = 0 + recursion(index+1, 1, prices, dp);
            profit = Integer.max(notTake , take);
        }
        else{
            int take = prices[index] + recursion(index+2, 1, prices, dp);
            int notTake = 0 + recursion(index+1, 0, prices, dp);
            profit = Integer.max(notTake , take);
        }
        return dp[index][buy] = profit;
    }
}