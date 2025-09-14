// Last updated: 9/14/2025, 9:11:10 AM
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //tabulation approach
        int n = arr.length;
        int []dp  = new int[n+1];
        for(int i=n-1; i>=0; i--){
            int maxAns = Integer.MIN_VALUE;
            int maxi = Integer.MIN_VALUE;
            for(int j=i; j<Integer.min(n, i+k); j++){
                maxi = Integer.max(maxi, arr[j]);
                                //length of the subarray
                int sum = maxi * (j - i + 1) + dp[j+1];
                maxAns = Integer.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
}