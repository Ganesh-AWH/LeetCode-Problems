// Last updated: 9/15/2025, 11:04:55 PM
/*
 * Dynammic approach 
 * t.c -> o(n^2)
 * s.c -> o(n^2)
*/

class Solution {
    public boolean checkValidString(String s) {
        //recursive solution
        //string , index, count
        int len = s.length();
        int [][]dp = new int[len][len];
        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        return checkString(s, 0, 0, dp) == 1;
    }
    public static int checkString(String s, int index, int count, int [][]dp){
        //checking if count reduces to -1 it indicates that invalid paranthesis        
        if(count < 0) return 0;

        if(index >= s.length()){
            return count == 0?1:0;
        }

        if(dp[index][count] != -1) return dp[index][count];

        char c = s.charAt(index);
        if(c == '('){
            return dp[index][count] =  checkString(s, index+1, count+1, dp);
        }
        if(c == ')'){
            return dp[index][count] = checkString(s, index+1, count-1, dp);
        }

        //else c = *
        // possible-1 '('
        int possible1 = checkString(s, index+1, count+1, dp);
        //possible-2 ')'
        int possible2 = checkString(s, index+1, count-1, dp);
        //possible-2 "empty"
        int possible3 = checkString(s, index+1, count, dp);
        return dp[index][count] = (possible1 == 1 || possible2 == 1|| possible3 == 1)?1:0;
    }
}