class Solution {
    public int maxProfit(int[] prices) {
        //dp solution
        int n = prices.length;
        int [][][]dp = new int[n][2][3];
        for(int [][]row1:dp){
            for(int []row2: row1){
                Arrays.fill(row2, -1);
            }
        }
        return recursion(0, 1, 2, prices, dp);
    }
    public int recursion(int index, int buy, int tran, int []prices, int [][][]dp){
        //base case
        if(index == prices.length || tran == 0) return 0;

        if(dp[index][buy][tran] != -1) return dp[index][buy][tran];
        int profit = 0;
        if(buy == 1){                                       
            int take = -prices[index] + recursion(index+1, 0, tran, prices, dp);
            int notTake = 0 + recursion(index+1, 1, tran, prices, dp);
            profit = Integer.max(take, notTake);
        }else{                                         //since we are selling 1 transaction is completed
            int take = prices[index] + recursion(index+1, 1, tran-1, prices, dp);
            int notTake = 0 + recursion(index+1, 0, tran, prices, dp);
            profit = Integer.max(take, notTake);
        }
        return dp[index][buy][tran] = profit;
    }
}