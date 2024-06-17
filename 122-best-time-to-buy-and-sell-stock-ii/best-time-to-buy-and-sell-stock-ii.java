class Solution {
    public int maxProfit(int[] prices) {
        //recursion solution
        int n = prices.length;
        int [][]dp = new int[n][2];
        for(int []row:dp){
            Arrays.fill(row, -1);
        }
        return recursion(0, 1, prices, n, dp);
    }
    public int recursion(int index, int buy, int []prices, int n, int [][]dp){
        //base case
        if(index == n) return 0;

        //if buy == 1 then we can buy the stock
        //if but == 0 then we can sell the stock
        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 1){
                //whether we can buy the stock or not
            //since we are buying the amount is reduced in our hand;
            int take = -prices[index] + recursion(index + 1, 0, prices, n, dp);
                                            //not buying
            int notTake = 0 + recursion(index+1, 1, prices, n, dp);
            profit = Integer.max(take, notTake);
        }else{
            int take = +prices[index] + recursion(index + 1, 1, prices, n, dp);
            int notTake = 0 + recursion(index + 1, 0, prices, n, dp);
            profit = Integer.max(take, notTake);
        }

        return dp[index][buy] = profit;

    }
}