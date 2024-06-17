class Solution {
    public int maxProfit(int[] prices) {
        //tabulation solution
        int n = prices.length;
        int [][][]dp = new int[n+1][2][3];

        for(int index=n-1; index>=0; index--){
            for(int buy=0; buy<=1; buy++){
                for(int tran=1; tran<=2; tran++){
                    int profit = 0;
                    if(buy == 1){                                       
                        int take = -prices[index] + dp[index+1][0][tran];
                        int notTake = 0 + dp[index+1][1][tran];
                        profit = Integer.max(take, notTake);
                    }else{                                        
                        int take = prices[index] + dp[index+1][1][tran-1];
                        int notTake = 0 + dp[index+1][0][tran];
                        profit = Integer.max(take, notTake);
                    }
                    dp[index][buy][tran] = profit;
                }
            }
        }
        return dp[0][1][2];
    }
}