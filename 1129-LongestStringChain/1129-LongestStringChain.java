// Last updated: 9/14/2025, 9:11:09 AM
class Solution {
    public int longestStrChain(String[] words) {
        //extension of longest increasing subsequence
        int n = words.length;
        int []dp = new int[n];
        Arrays.fill(dp, 1);
        //sorting the words based on length
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        int maxi = Integer.MIN_VALUE;
        for(int index=0; index<n; index++){
            for(int prev=0; prev<index; prev++){
                if(checkString(words[index], words[prev]) && dp[prev]+1 > dp[index]){
                    dp[index] = dp[prev]+1;
                }
            }
            maxi = Integer.max(maxi, dp[index]);
        }
        return maxi;
    }
    public boolean checkString(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        if(n != m+1) return false;
        int i = 0;
        int j = 0;
        while(i < n){
            if(j<m && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }

        return n == i && m == j;
    }
}