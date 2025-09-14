// Last updated: 9/14/2025, 9:16:51 AM
class Solution {
    public int maxProfit(int[] prices) {
        //tabulation solution
        int n = prices.length;
        int [][]front = new int[2][3];

        for(int index=n-1; index>=0; index--){
            int [][]curr = new int[2][3];
            for(int buy=0; buy<=1; buy++){
                for(int tran=1; tran<=2; tran++){
                    int profit = 0;
                    if(buy == 1){                                       
                        int take = -prices[index] + front[0][tran];
                        int notTake = 0 + front[1][tran];
                        profit = Integer.max(take, notTake);
                    }else{                                        
                        int take = prices[index] + front[1][tran-1];
                        int notTake = 0 + front[0][tran];
                        profit = Integer.max(take, notTake);
                    }
                    curr[buy][tran] = profit;
                }
            }
            front = curr;
        }
        return front[1][2];
    }
}