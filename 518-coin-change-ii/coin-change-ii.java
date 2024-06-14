class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int []prev = new int[amount+1]; 
        //tabulation solution with space optimization 
        prev[0] = 1;
        for(int t=0;t<=amount;t++){
            if(t%coins[0] == 0) prev[t] = 1;
        }

        for(int index = 1;index<n;index++){
            int []curr = new int[amount+1];
            for(int t=0;t<=amount;t++){
                int notPick = prev[t];
                int pick = 0;
                if(coins[index]<=t){
                    pick = curr[t-coins[index]];
                }
                curr[t] = pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}