class Solution {
    public int minCut(String s) {
        int n = s.length();
        //recursive approach
        int []dp = new int[n];
        Arrays.fill(dp, -1);
        return recursion(0, s.toCharArray(), n, dp)-1;
    }
    public int recursion(int i, char []str, int n, int []dp){
        if(i == n) return 0; 
        if(dp[i] != -1) return dp[i];
        //partitioning
        int mini = Integer.MAX_VALUE;
        for(int j=i; j<n; j++){
            if(isPalindrome(i, j, str)){
                int cost = 1 + recursion(j+1, str, n, dp);
                mini = Integer.min(mini, cost);
            }
        }

        return dp[i] = mini;
    }
    public boolean isPalindrome(int s, int e, char []str){
        while(s<e){
            if(str[s] != str[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}