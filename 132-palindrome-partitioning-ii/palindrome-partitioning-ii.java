class Solution {
    public int minCut(String s) {
        int n = s.length();
        //tabulation approach
        int []dp = new int[n+1];
        char []str = s.toCharArray();
        for(int i=n-1; i>=0; i--){
            int mini = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                if(isPalindrome(i, j, str)){
                    int cost = 1 + dp[j+1];
                    mini = Integer.min(mini, cost);
                }
            }
            dp[i] = mini;
        }
        return dp[0] - 1;
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