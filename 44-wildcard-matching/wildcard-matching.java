class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        //memoization solution
        int [][]dp = new int[m][n];

        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        //changed that first string have wildcard
        return recursion(m-1, n-1, p, s, dp) == 1;
    }
    public int recursion(int i, int j, String s, String p, int [][]dp){
        //base case
        if(i < 0 && j < 0) return 1;

        //if s gets end and p is remaining then return 0
        if(i < 0 && j >= 0) return 0;

        //if s is not over and p gets over then remaing character of s should be star
        if(i>=0 && j<0){
            for(;i>=0;i--){
                if(s.charAt(i) != '*') return 0;
            }
            return 1;
        }
        
        if(dp[i][j] != -1) return 0;

        //if both the character matches and if s1 == ? then it can match with s2
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);
        if(c1 == c2 || c1 == '?'){
            return dp[i][j] = recursion(i-1, j-1, s, p, dp);
        }
        //if they don't match and the character is '*'
        if(c1 == '*'){
            //i don't match the star
            int call1 = recursion(i-1, j, s, p, dp);
            //i match the character with * 
            int call2 = recursion(i, j-1, s, p, dp);

            return dp[i][j] = call1 == 1 || call2 == 1 ? 1 : 0;
        }
        //if the two character does not match and character is not equal to star
        return 0;
    }
}