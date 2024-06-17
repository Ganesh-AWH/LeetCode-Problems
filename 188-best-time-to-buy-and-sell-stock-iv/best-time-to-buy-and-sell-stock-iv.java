class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //recursion solution
        int [][]dp = new int[n][k*2];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        return recursion(0, 0, prices, k*2, dp);
        //there is no need of buy variable because with the help of transaction we can get that variable
        //tran -> 0(buy), 1(sell), 2(buy), 3(sell) ...........
    }
    public int recursion(int index, int tran,int []prices,int k, int [][]dp){
        //base case 
        if(index == prices.length || tran == k) return 0;

        if(dp[index][tran] != -1) return dp[index][tran];
        int profit = 0;
        if(tran % 2 == 0){
            int take = -prices[index] + recursion(index+1, tran+1, prices, k, dp);
            int notTake = 0 + recursion(index+1, tran, prices, k, dp);
            profit = Integer.max(take, notTake);
        }
        else{
            int take = prices[index] + recursion(index+1, tran+1, prices, k, dp);
            int notTake = 0 + recursion(index+1, tran, prices, k, dp);
            profit = Integer.max(take, notTake);
        }
        return dp[index][tran] = profit;
    }
}