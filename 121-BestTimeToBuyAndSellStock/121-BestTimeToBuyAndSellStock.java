// Last updated: 9/14/2025, 9:16:55 AM
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        for(int i:prices){
            buy = Integer.min(buy,i);
            profit = Integer.max(profit,i-buy);
        }
        return profit;
    }
}