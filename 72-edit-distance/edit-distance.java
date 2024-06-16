class Solution {
    public int minDistance(String word1, String word2) {
        // memoization solution
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int[n][m];
        for(int []row: dp){
            Arrays.fill(row,-1);
        }
        return recursion(n-1, m-1, word1, word2, dp);
    }
    public int recursion(int i, int j, String word1, String word2, int [][]dp){
        //base case
        // str1 = "" | str2 = ro
        if(i<0){
            // to convert empty string to "ro" we need to insert 2 characters
            return j+1;
        }
        //str1 = hor | str2 = ""
        if(j<0){
            return i+1;
        }

        if(dp[i][j] != -1) return dp[i][j];
        //what if both character matches
        if(word1.charAt(i) == word2.charAt(j)){
            //since we are not performing any operaion so 0
            return dp[i][j] = 0 + recursion(i-1, j-1, word1, word2, dp);
        }

        //if the character does not matches then we gonna perform all the operations
        
        //insertion (if we insert character to word1 then i remains same consider hypothetically we are inserting character to word1)
                                //since the inserted character matches so j is decreased
        int insert = 1 + recursion(i, j-1, word1, word2, dp);

        //deletion (if we delete the character from word1 then i will decrease and j remains same)
        int delete = 1 + recursion(i-1, j, word1, word2, dp);

        //replace (if we replace the character in word1 then the character matches i-1 and j-1)
        int replace = 1 + recursion(i-1, j-1, word1, word2, dp);

        return dp[i][j] = Integer.min(insert, Integer.min(delete, replace));

    }
}