// Last updated: 9/14/2025, 9:14:44 AM
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        //tabulation solution wiht space optmization
        int n = coins.length;
        int []prev = new int[amount+1];
        for(int a=0;a<=amount;a++){
            if(a % coins[0] == 0) prev[a] = a/coins[0];
            else prev[a] = (int)(1e9);
        }
        for(int index=1;index<n;index++){
            int []curr = new int[amount+1];
            for(int a=0;a<=amount;a++){
                int notPick = 0 + prev[a];
                int pick = (int)(1e9);
                if(coins[index] <= a){
                        //picking up the coin so 1
                    pick = 1 + curr[a-coins[index]];
                }
                curr[a] = Integer.min(notPick, pick);
            }
            prev = curr;
        }
        int ans = prev[amount];        
        return ans >= 1e9 ? -1 : ans;
    }
}