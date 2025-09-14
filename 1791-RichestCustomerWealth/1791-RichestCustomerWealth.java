// Last updated: 9/14/2025, 9:09:27 AM
class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int maxWealth = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int sum  = 0;
            for(int j=0;j<n;j++){
                sum += accounts[i][j];
            }
            maxWealth = Integer.max(maxWealth,sum);
        }
        return maxWealth;
    }
}

//TC:O(n*n)
//SC:O(1)