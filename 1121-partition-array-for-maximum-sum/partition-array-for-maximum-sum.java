class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //memoization approach
        int n = arr.length;
        int []dp  = new int[n];
        Arrays.fill(dp, -1);
        return recursion(0, arr, n, k, dp);
    }
    public int recursion(int i, int []arr, int n, int k, int []dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int maxAns = Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int j=i; j<Integer.min(n, i+k); j++){
            maxi = Integer.max(maxi, arr[j]);
                            //length of the subarray
            int sum = maxi * (j - i + 1) + recursion(j+1, arr, n, k, dp);
            maxAns = Integer.max(maxAns, sum);
        }
        return dp[i] = maxAns;
    }
}