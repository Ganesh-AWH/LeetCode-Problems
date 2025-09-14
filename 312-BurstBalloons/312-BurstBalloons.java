// Last updated: 9/14/2025, 9:14:46 AM
class Solution {
    public int maxCoins(int[] nums) {
        //tabulation approach
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i: nums) list.add(i);
        list.add(1);
        int n = list.size();
        int  [][]dp = new int[n+1][n+1];

        for(int i=n-2; i>=1; i--){
            for(int j=1; j<=n-2; j++){
                if(i > j) continue;
                int maxi = Integer.MIN_VALUE;
                for(int index = i; index<=j; index++){
                    int coins = list.get(i-1) * list.get(index) * list.get(j+1) + 
                                         dp[i][index-1] + dp[index+1][j];
                    maxi = Integer.max(coins, maxi);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n-2];
    }
}