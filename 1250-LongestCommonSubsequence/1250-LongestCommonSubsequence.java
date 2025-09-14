// Last updated: 9/14/2025, 9:10:52 AM
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //tabulation solution with space optimization
        //shifting the index -1 will become 0, 0->1 ....
        int l1 = text1.length();
        int l2 = text2.length();
        int []prev = new int[l2+1];

        for(int index1=1; index1<=l1; index1++){
            int []curr = new int[l2+1];
            for(int index2=1; index2<=l2; index2++){
                if(text1.charAt(index1-1) == text2.charAt(index2-1))
                    curr[index2] = 1 + prev[index2-1];
                else{
                    //if the character does not matches
                    int part1 = 0 + prev[index2];
                    int part2 = 0 + curr[index2-1];
                    curr[index2] = Integer.max(part1,part2);
                }
            }
            prev = curr;
        }
        return prev[l2];
    }
}