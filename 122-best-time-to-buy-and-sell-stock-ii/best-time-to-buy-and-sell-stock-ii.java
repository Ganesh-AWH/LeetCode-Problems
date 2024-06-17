class Solution {
    public int maxProfit(int[] prices) {
        //tabulation solution with space optimization
        int n = prices.length;
        int []front = new int[2];
        front[0] = front[1] = 0;
        for(int index=n-1; index>=0; index--){
            int []curr = new int[2];
            for(int buy = 1; buy>=0; buy--){
                int profit = 0;
                if(buy == 1){
                    int take = -prices[index] + front[0];
                    int notTake = 0 + front[1];
                    profit = Integer.max(take, notTake);
                }else{
                    int take = +prices[index] + front[1];
                    int notTake = 0 + front[0];
                    profit = Integer.max(take, notTake);
                }

                curr[buy] = profit;
            }
            front = curr;
        }
        return front[1];
    }
}