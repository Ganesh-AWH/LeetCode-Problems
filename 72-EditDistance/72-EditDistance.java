// Last updated: 9/14/2025, 9:17:42 AM
class Solution {
    public int minDistance(String word1, String word2) {
        // tabulation solution with space optimization
        int n = word1.length();
        int m = word2.length();
        //since the base in recursion going negative shifting the index for tabulation method
        int []prev = new int[m+1];
        //base case conversion
        for(int j=0; j<=m; j++){
            prev[j] = j;
        }

        for(int i=1; i<=n; i++){
            int []curr = new  int[m+1];
            curr[0] = i;
            for(int j=1; j<=m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    //since we are not performing any operaion so 0
                    curr[j] = 0 + prev[j-1];
                }
                else{
                    int insert = 1 + curr[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];

                    curr[j] = Integer.min(insert, Integer.min(delete, replace));
                }

            }
            prev = curr;
        }
        return prev[m];
    }
}