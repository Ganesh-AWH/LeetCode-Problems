class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //recursion solution
        //shifting the index -1 will become 0, 0->1 ....
        int l1 = text1.length();
        int l2 = text2.length();
        int [][]dp = new int[l1+1][l2+1];
        //base case
        for(int i=0;i<l1;i++) dp[i][0] = 0;
        for(int j=0;j<l2;j++) dp[0][j] = 0;

        for(int index1=1; index1<=l1; index1++){
            for(int index2=1; index2<=l2; index2++){
                if(text1.charAt(index1-1) == text2.charAt(index2-1))
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                else{
                    //if the character does not matches
                    int part1 = 0 + dp[index1-1][index2];
                    int part2 = 0 + dp[index1][index2-1];
                    dp[index1][index2] = Integer.max(part1,part2);
                }
            }
        }
        return dp[l1][l2];
    }
}