// Last updated: 9/14/2025, 9:12:51 AM
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        //tabulation solution with space optimization
        int []front = new int[2];

        for(int index=n-1; index>=0; index--){
            int []curr = new int[2];
            for(int buy=0; buy<=1; buy++){
                int profit = 0;
                if(buy == 1){
                    int take = -prices[index] - fee + front[0];
                    int notTake = 0 + front[1];
                    profit = Integer.max(take, notTake);
                }
                else{
                    int take = prices[index] + front[1];
                    int notTake = 0 +  front[0];
                    profit = Integer.max(take, notTake);
                }

                curr[buy] = profit;
            }
            front = curr;
        }
        return front[1];
    }
}