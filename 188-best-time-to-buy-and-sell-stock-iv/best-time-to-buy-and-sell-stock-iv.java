class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //tabulation solution
        int [][]dp = new int[n+1][k*2+1]; 
        for(int index=n-1; index>=0; index--){
            for(int tran=k*2-1; tran>=0; tran--){
                int profit = 0;
                if(tran % 2 == 0){
                    int take = -prices[index] + dp[index+1][tran+1];
                    int notTake = 0 + dp[index+1][tran];
                    profit = Integer.max(take, notTake);
                }
                else{
                    int take = prices[index] + dp[index+1][tran+1];
                    int notTake = 0 + dp[index+1][tran];
                    profit = Integer.max(take, notTake);
                }
                dp[index][tran] = profit;
            }
        }
        return dp[0][0];
        //there is no need of buy variable because with the help of transaction we can get that variable
        //tran -> 0(buy), 1(sell), 2(buy), 3(sell) ...........
    }
}