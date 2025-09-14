// Last updated: 9/14/2025, 9:11:04 AM
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        //using lcs and lcs printing and dp table of lcs

        //shifting the index -1 will become 0, 0->1 ....
        int l1 = str1.length();
        int l2 = str2.length();
        int [][]dp = new int[l1+1][l2+1];
        
        for(int index1=1; index1<=l1; index1++){
            for(int index2=1; index2<=l2; index2++){
                if(str1.charAt(index1-1) == str2.charAt(index2-1))
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                else{
                    //if the character does not matches
                    int part1 = 0 + dp[index1-1][index2];
                    int part2 = 0 + dp[index1][index2-1];
                    dp[index1][index2] = Integer.max(part1,part2);
                }
            }
        }

        //finding the length of the shortest common supersequence
        //we are using the common subsequence only once
        
        // int x = dp[l1][l2];
        // int len = l1 + l2 - x;

        StringBuilder sb = new StringBuilder();
        int i = l1;
        int j = l2;
        while(i>0 && j>0){
            char c1 = str1.charAt(i-1);
            char c2 = str2.charAt(j-1);
            if(c1 == c2){
                sb.append(c1);
                i--;
                j--;
            }   

            //i-1 is greater then we are going up and we are missing current i then add it to the ans before moving
            else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(c1);
                i--;
            }
            //j-1 is greater then we are going left and we are missing current j add it to the ans before moving
            else{
                sb.append(c2);
                j--;
            }
        }
        
        while(i > 0){
            sb.append(str1.charAt(i-1));
            i--;
        } 
        while(j > 0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}