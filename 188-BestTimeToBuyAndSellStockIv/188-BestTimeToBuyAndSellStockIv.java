// Last updated: 9/14/2025, 9:15:56 AM
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //tabulation solution with space optimization
        int []front = new int[k*2+1]; 
        for(int index=n-1; index>=0; index--){
            int []curr = new int[k*2+1]; 
            for(int tran=k*2-1; tran>=0; tran--){
                int profit = 0;
                if(tran % 2 == 0){
                    int take = -prices[index] + front[tran+1];
                    int notTake = 0 + front[tran];
                    profit = Integer.max(take, notTake);
                }
                else{
                    int take = prices[index] + front[tran+1];
                    int notTake = 0 + front[tran];
                    profit = Integer.max(take, notTake);
                }
                curr[tran] = profit;
            }
            front = curr;
        }
        return front[0];
        //there is no need of buy variable because with the help of transaction we can get that variable
        //tran -> 0(buy), 1(sell), 2(buy), 3(sell) ...........
    }
}